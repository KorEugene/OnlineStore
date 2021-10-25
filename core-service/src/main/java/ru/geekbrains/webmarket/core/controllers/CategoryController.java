package ru.geekbrains.webmarket.core.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.webmarket.api.dtos.CategoryDto;
import ru.geekbrains.webmarket.api.exceptions.ResourceNotFoundException;
import ru.geekbrains.webmarket.core.services.CategoryService;
import ru.geekbrains.webmarket.core.utils.Converter;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CategoryController {
    private final CategoryService categoryService;
    private final Converter converter;

    @GetMapping("/{id}")
    public CategoryDto findById(@PathVariable Long id) {
        return converter.categoryToDto(categoryService.findByIdWithProducts(id).orElseThrow(() -> new ResourceNotFoundException("Category id = " + id + " not found")));
    }
}
