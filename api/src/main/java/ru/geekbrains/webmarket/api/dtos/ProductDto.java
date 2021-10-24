package ru.geekbrains.webmarket.api.dtos;

//import org.hibernate.validator.constraints.Length;

//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotNull;

public class ProductDto {
    private Long id;

//    @NotNull(message = "Товар должен иметь название")
//    @Length(min = 3, max = 255, message = "Длина названия товара должна составлять 3-255 символов")
    private String title;

//    @Min(value = 1, message = "Цена товара не может быть менее 1 руб.")
    private int price;

//    @NotNull(message = "Товар должен иметь категорию")
    private String categoryTitle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public ProductDto() {
    }

    public ProductDto(Long id, String title, int price, String categoryTitle) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.categoryTitle = categoryTitle;
    }
}
