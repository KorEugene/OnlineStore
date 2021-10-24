package ru.geekbrains.webmarket.core.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.geekbrains.webmarket.api.dtos.ProductDto;
import ru.geekbrains.webmarket.core.entities.CategoryEntity;
import ru.geekbrains.webmarket.core.entities.ProductEntity;
import ru.geekbrains.webmarket.core.repositories.ProductRepository;

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

        ProductDto productDto = new ProductDto(productEntity.getId(), productEntity.getTitle(), productEntity.getPrice(), productEntity.getTitle());
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
