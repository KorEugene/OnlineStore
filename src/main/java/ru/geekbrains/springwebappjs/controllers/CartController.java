package ru.geekbrains.springwebappjs.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.springwebappjs.dtos.ProductDto;
import ru.geekbrains.springwebappjs.exceptions.ResourceNotFoundException;
import ru.geekbrains.springwebappjs.entities.Category;
import ru.geekbrains.springwebappjs.entities.Product;
import ru.geekbrains.springwebappjs.services.CartService;
import ru.geekbrains.springwebappjs.services.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    private final CategoryService categoryService;

    @GetMapping
    public List<ProductDto> getProducts() {
        return cartService.getProducts().stream().map(ProductDto::new).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody ProductDto productDto) {
        Product product = new Product(productDto);
        Category category = categoryService.findByTitle(productDto.getCategoryTitle()).orElseThrow(() -> new ResourceNotFoundException("Category title = " + productDto.getCategoryTitle() + " not found"));
        product.setCategory(category);
        cartService.addProduct(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> removeProduct(@RequestParam(name = "p") Long id) {
        cartService.removeProductById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
