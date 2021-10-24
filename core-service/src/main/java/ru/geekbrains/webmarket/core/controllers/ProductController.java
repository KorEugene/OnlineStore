package ru.geekbrains.webmarket.core.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.webmarket.api.dtos.ProductDetailsDto;
import ru.geekbrains.webmarket.api.dtos.ProductDto;
import ru.geekbrains.webmarket.api.exceptions.ResourceNotFoundException;
import ru.geekbrains.webmarket.core.entities.CategoryEntity;
import ru.geekbrains.webmarket.core.entities.ProductEntity;
import ru.geekbrains.webmarket.core.exceptions.DataValidationException;
import ru.geekbrains.webmarket.core.services.CategoryService;
import ru.geekbrains.webmarket.core.services.ProductService;
import ru.geekbrains.webmarket.core.utils.Converter;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;
    private final Converter converter;

    @GetMapping
    public Page<ProductDto> findAll(
            @RequestParam(defaultValue = "1", name = "p") int pageIndex,
            @RequestParam MultiValueMap<String, String> params
    ) {
        if (pageIndex < 1) {
            pageIndex = 1;
        }
        return productService.findAll(pageIndex - 1, 10, params)
                .map(converter::productToDto);
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        ProductEntity product = productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product id = " + id + " not found"));
        return converter.productToDto(product);
    }

    @GetMapping("/{id}/details")
    public ProductDetailsDto findByIdWithDetails(@PathVariable Long id) {
        return productService.findByIdWithDetails(id);
    }

    @PostMapping
    public ProductDto save(@RequestBody @Validated ProductDto productDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new DataValidationException(bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList()));
        }
        ProductEntity product = new ProductEntity();
        product.setPrice(productDto.getPrice());
        product.setTitle(productDto.getTitle());
        CategoryEntity categoryEntity = categoryService.findByTitle(productDto.getCategoryTitle()).orElseThrow(() -> new ResourceNotFoundException("Category title = " + productDto.getCategoryTitle() + " not found"));
        product.setCategoryEntity(categoryEntity);
        productService.save(product);
        return converter.productToDto(product);
    }

    @PutMapping
    public void updateProduct(@RequestBody ProductDto productDto) {
        productService.updateProductFromDto(productDto);
    }
}
