package ru.geekbrains.springwebappjs.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.springwebappjs.dtos.ProductDto;
import ru.geekbrains.springwebappjs.entities.CategoryEntity;
import ru.geekbrains.springwebappjs.entities.ProductEntity;
import ru.geekbrains.springwebappjs.exceptions.ResourceNotFoundException;
import ru.geekbrains.springwebappjs.repositories.ProductRepository;
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


    public Page<ProductEntity> findAll(int pageIndex, int pageSize) {
        return productRepository.findAll(PageRequest.of(pageIndex, pageSize));
    }

    public Optional<ProductEntity> findById(Long id) {
        return productRepository.findById(id);
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

    public Product findByIdAsSoap(long id) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product id = " + id + " not found"));
        return SOAPConverter.convertProductEntityToProduct(productEntity);
    }

    public List<Product> findAllAsSoap() {
        return productRepository.findAll().stream().map(SOAPConverter::convertProductEntityToProduct).collect(Collectors.toList());
    }
}
