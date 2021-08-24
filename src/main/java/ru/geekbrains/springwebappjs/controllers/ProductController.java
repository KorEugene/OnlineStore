package ru.geekbrains.springwebappjs.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.springwebappjs.dtos.ProductDto;
import ru.geekbrains.springwebappjs.exceptions.ResourceNotFoundException;
import ru.geekbrains.springwebappjs.model.Category;
import ru.geekbrains.springwebappjs.model.Product;
import ru.geekbrains.springwebappjs.services.CategoryService;
import ru.geekbrains.springwebappjs.services.ProductService;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping
    public Page<ProductDto> findAll(@RequestParam(defaultValue = "1", name = "p") int pageIndex) {
        if (pageIndex < 1) {
            pageIndex = 1;
        }
        return productService.findAll(pageIndex - 1, 10).map(ProductDto::new);
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        Product product = productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product id = " + id + " not found"));
        return new ProductDto(product);
    }

    @PostMapping
    public ProductDto save(@RequestBody ProductDto productDto) {
        Product product = new Product();
        product.setPrice(productDto.getPrice());
        product.setTitle(productDto.getTitle());
        Category category = categoryService.findByTitle(productDto.getCategoryTitle()).orElseThrow(() -> new ResourceNotFoundException("Category title = " + productDto.getCategoryTitle() + " not found"));
        product.setCategory(category);
        productService.save(product);
        return new ProductDto(product);
    }

    @DeleteMapping
    public void removeProduct(@RequestParam(name = "p") Long id) {
        productService.deleteById(id);
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        Product product = productService.findById(productDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Product id = " + productDto.getId() + " not found"));
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        Category category = categoryService.findByTitle(productDto.getCategoryTitle()).orElseThrow(() -> new ResourceNotFoundException("Category title = " + productDto.getCategoryTitle() + " not found"));
        product.setCategory(category);
        productService.save(product);
        return new ProductDto(product);
    }
}
