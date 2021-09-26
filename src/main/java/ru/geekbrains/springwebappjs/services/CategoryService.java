package ru.geekbrains.springwebappjs.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.springwebappjs.entities.CategoryEntity;
import ru.geekbrains.springwebappjs.repositories.CategoryRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Optional<CategoryEntity> findByTitle(String title) {
        return categoryRepository.findByTitle(title);
    }

    public Optional<CategoryEntity> findById(Long id) {
        return categoryRepository.findById(id);
    }

    public Optional<CategoryEntity> findByIdWithProducts(Long id) {
        return categoryRepository.findByIdWithProducts(id);
    }
}
