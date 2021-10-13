package ru.geekbrains.springwebappjs.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;
import ru.geekbrains.springwebappjs.dtos.CommentResponseDto;
import ru.geekbrains.springwebappjs.dtos.ProductDetailsDto;
import ru.geekbrains.springwebappjs.dtos.ProductDto;
import ru.geekbrains.springwebappjs.entities.CategoryEntity;
import ru.geekbrains.springwebappjs.entities.ProductEntity;
import ru.geekbrains.springwebappjs.exceptions.ResourceNotFoundException;
import ru.geekbrains.springwebappjs.repositories.ProductRepository;
import ru.geekbrains.springwebappjs.repositories.specifications.ProductSpecifications;
import ru.geekbrains.springwebappjs.soap.products.Product;
import ru.geekbrains.springwebappjs.utils.SOAPConverter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    private static final String FILTER_MIN_PRICE = "min_price";
    private static final String FILTER_MAX_PRICE = "max_price";
    private static final String FILTER_TITLE = "title";

    public Page<ProductEntity> findAll(int pageIndex, int pageSize, MultiValueMap<String, String> rqParams) {
        return productRepository.findAll(constructSpecification(rqParams), PageRequest.of(pageIndex, pageSize));
    }

    public Optional<ProductEntity> findById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    public ProductDetailsDto findByIdWithDetails(Long id) {
        ProductEntity product = productRepository.findById(id).orElseGet(ProductEntity::new);

        ProductDetailsDto productDetailsDto = new ProductDetailsDto();
        productDetailsDto.setTitle(product.getTitle());
        productDetailsDto.setPrice(product.getPrice());
        productDetailsDto.setCategoryTitle(product.getCategoryEntity().getTitle());
        productDetailsDto.setCommentList(product.getComments().stream().map(CommentResponseDto::new).collect(Collectors.toList()));
        return productDetailsDto;
    }

    public ProductEntity save(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    @Transactional
    public void updateProductFromDto(ProductDto productDto) {
        ProductEntity productEntity = findById(productDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Product id = " + productDto.getId() + " not found"));
        productEntity.setPrice(productDto.getPrice());
        productEntity.setTitle(productDto.getTitle());
        if (!productEntity.getCategoryEntity().getTitle().equals(productDto.getCategoryTitle())) {
            CategoryEntity categoryEntity = categoryService.findByTitle(productDto.getCategoryTitle()).orElseThrow(() -> new ResourceNotFoundException("Category title = " + productDto.getCategoryTitle() + " not found"));
            productEntity.setCategoryEntity(categoryEntity);
        }
    }

    public Optional<ProductEntity> findByTitle(String title) {
        return productRepository.findByTitle(title);
    }

    private Specification<ProductEntity> constructSpecification(MultiValueMap<String, String> params) {
        Specification<ProductEntity> spec = Specification.where(null);
        if (params.containsKey(FILTER_MIN_PRICE) && !params.getFirst(FILTER_MIN_PRICE).isBlank()) {
            int minPrice = Integer.parseInt(params.getFirst(FILTER_MIN_PRICE));
            spec = spec.and(ProductSpecifications.priceGreaterOrEqualsThan(minPrice));
        }
        if (params.containsKey(FILTER_MAX_PRICE) && !params.getFirst(FILTER_MAX_PRICE).isBlank()) {
            int maxPrice = Integer.parseInt(params.getFirst(FILTER_MAX_PRICE));
            spec = spec.and(ProductSpecifications.priceLesserOrEqualsThan(maxPrice));
        }
        if (params.containsKey(FILTER_TITLE) && !params.getFirst(FILTER_TITLE).isBlank()) {
            String title = params.getFirst(FILTER_TITLE);
            spec = spec.and(ProductSpecifications.titleLike(title));
        }
        return spec;
    }

    public Product findByIdAsSoap(long id) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product id = " + id + " not found"));
        return SOAPConverter.convertProductEntityToProduct(productEntity);
    }

    public List<Product> findAllAsSoap() {
        return productRepository.findAll().stream().map(SOAPConverter::convertProductEntityToProduct).collect(Collectors.toList());
    }
}
