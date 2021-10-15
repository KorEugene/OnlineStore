package ru.geekbrains.springwebappjs.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.springwebappjs.dtos.ProductDetailsDto;
import ru.geekbrains.springwebappjs.dtos.ProductDto;
import ru.geekbrains.springwebappjs.entities.CategoryEntity;
import ru.geekbrains.springwebappjs.entities.ProductEntity;
import ru.geekbrains.springwebappjs.exceptions.DataValidationException;
import ru.geekbrains.springwebappjs.exceptions.ResourceNotFoundException;
import ru.geekbrains.springwebappjs.services.CategoryService;
import ru.geekbrains.springwebappjs.services.ProductService;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping
    public Page<ProductDto> findAll(
            @RequestParam(defaultValue = "1", name = "p") int pageIndex,
            @RequestParam MultiValueMap<String, String> params
    ) {
        if (pageIndex < 1) {
            pageIndex = 1;
        }
        return productService.findAll(pageIndex - 1, 10, params).map(ProductDto::new);
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return new ProductDto(productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product id = " + id + " not found")));
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
        ProductEntity productEntity = new ProductEntity();
        productEntity.setPrice(productDto.getPrice());
        productEntity.setTitle(productDto.getTitle());
        CategoryEntity categoryEntity = categoryService.findByTitle(productDto.getCategoryTitle()).orElseThrow(() -> new ResourceNotFoundException("Category title = " + productDto.getCategoryTitle() + " not found"));
        productEntity.setCategoryEntity(categoryEntity);
        productService.save(productEntity);
        return new ProductDto(productEntity);
    }

    @PutMapping
    public void updateProduct(@RequestBody ProductDto productDto) {
        productService.updateProductFromDto(productDto);
    }
}
