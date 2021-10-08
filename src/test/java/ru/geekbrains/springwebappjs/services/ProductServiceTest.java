package ru.geekbrains.springwebappjs.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.geekbrains.springwebappjs.dtos.ProductDto;
import ru.geekbrains.springwebappjs.entities.CategoryEntity;
import ru.geekbrains.springwebappjs.entities.ProductEntity;
import ru.geekbrains.springwebappjs.repositories.ProductRepository;

import java.util.Optional;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private CategoryService categoryService;

    @Test
    void updateProductFromDto() {

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(1L);
        categoryEntity.setTitle("Food");

        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(1L);
        productEntity.setTitle("Bread");
        productEntity.setPrice(25);
        productEntity.setCategoryEntity(categoryEntity);

        Optional<ProductEntity> optionalProduct = Optional.of(productEntity);
        Mockito.doReturn(optionalProduct).when(productRepository).findById(1L);

        ProductDto productDto = new ProductDto(productEntity);
        productDto.setCategoryTitle("NotFood");

        CategoryEntity newCategoryEntity = new CategoryEntity();
        categoryEntity.setId(2L);
        categoryEntity.setTitle("NotFood");

        Optional<CategoryEntity> optionalCategory = Optional.of(newCategoryEntity);
        Mockito.doReturn(optionalCategory).when(categoryService).findByTitle("NotFood");

        productService.updateProductFromDto(productDto);

        Assertions.assertEquals("NotFood", productEntity.getCategoryEntity().getTitle());

    }
}
