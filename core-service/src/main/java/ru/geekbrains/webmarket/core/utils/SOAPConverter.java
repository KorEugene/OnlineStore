package ru.geekbrains.webmarket.core.utils;

import ru.geekbrains.webmarket.core.entities.ProductEntity;
import ru.geekbrains.webmarket.core.soap.categories.Category;
import ru.geekbrains.webmarket.core.soap.products.Product;

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
