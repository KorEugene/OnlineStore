package ru.geekbrains.springwebappjs.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import ru.geekbrains.springwebappjs.entities.ProductEntity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class ProductDto {
    private Long id;

    @NotNull(message = "Товар должен иметь название")
    @Length(min = 3, max = 255, message = "Длина названия товара должна составляет 3-255 символов")
    private String title;

    @Min(value = 1, message = "Цена товара не может быть менее 1 руб.")
    private int price;

    @NotNull(message = "Товар должен иметь категорию")
    private String categoryTitle;

    public ProductDto(ProductEntity productEntity) {
        this.id = productEntity.getId();
        this.title = productEntity.getTitle();
        this.price = productEntity.getPrice();
        this.categoryTitle = productEntity.getCategoryEntity().getTitle();
    }
}
