package ru.geekbrains.springwebappjs.utils;

import ru.geekbrains.springwebappjs.entities.ProductEntity;
import ru.geekbrains.springwebappjs.soap.categories.Category;
import ru.geekbrains.springwebappjs.soap.products.Product;

public class SOAPConverter {

    private SOAPConverter() {
    }

    public static Product convertProductEntityToProduct(ProductEntity pe) {
        Product product = new Product();
        product.setId(pe.getId());
        product.setTitle(pe.getTitle());
        product.setPrice(pe.getPrice());
        Category category = new Category();
        category.setId(pe.getCategoryEntity().getId());
        category.setTitle(pe.getCategoryEntity().getTitle());
        product.setCategory(category);
        return product;
    }
}
