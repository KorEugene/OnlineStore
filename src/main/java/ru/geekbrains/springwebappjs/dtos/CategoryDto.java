package ru.geekbrains.springwebappjs.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.springwebappjs.entities.CategoryEntity;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class CategoryDto {
    private Long id;
    private String title;
    private List<ProductDto> products;

    public CategoryDto(CategoryEntity categoryEntity) {
        this.id = categoryEntity.getId();
        this.title = categoryEntity.getTitle();
        this.products = categoryEntity.getProductEntities().stream().map(ProductDto::new).collect(Collectors.toList());
    }
}
