package ru.geekbrains.springwebappjs.utils;

import ru.geekbrains.springwebappjs.entities.ProductEntity;
import ru.geekbrains.springwebappjs.soap.products.Product;

public class SOAPConverter {

    private SOAPConverter() {
    }

    public static Product convertProductEntityToProduct(ProductEntity pe) {
        Product product = new Product();
        product.setId(pe.getId());
        product.setTitle(pe.getTitle());
        product.setPrice(pe.getPrice());
        product.setCategoryName(pe.getCategory().getTitle());
        return product;
    }
}
