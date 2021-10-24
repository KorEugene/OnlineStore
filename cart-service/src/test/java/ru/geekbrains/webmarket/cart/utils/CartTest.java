package ru.geekbrains.webmarket.cart.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.geekbrains.webmarket.api.dtos.ProductDto;

class CartTest {

    private Cart cart;

    private static ProductDto product1;
    private static ProductDto product2;

    @BeforeAll
    static void initProducts() {
        product1 = new ProductDto();
        product1.setId(1L);
        product1.setTitle("Cheese");
        product1.setPrice(100);

        product2 = new ProductDto();
        product2.setId(2L);
        product2.setTitle("Bread");
        product2.setPrice(50);
    }

    @BeforeEach
    void init() {
        cart = new Cart();
    }

    @Test
    void add() {
        Assertions.assertEquals(0,cart.getItems().size());
        Assertions.assertEquals(0,cart.getTotalPrice());

        cart.add(product1);
        Assertions.assertEquals(1,cart.getItems().size());
        Assertions.assertEquals(100,cart.getTotalPrice());

        cart.add(product1);
        Assertions.assertEquals(1,cart.getItems().size());
        Assertions.assertEquals(200,cart.getTotalPrice());

        cart.add(product2);
        Assertions.assertEquals(1,cart.getItems().size());
        Assertions.assertEquals(200,cart.getTotalPrice());

        cart.add(product2);
        Assertions.assertEquals(2,cart.getItems().size());
        Assertions.assertEquals(250,cart.getTotalPrice());
    }

    @Test
    void decrement() {
        cart.add(product1);
        cart.add(product1);
        cart.add(product1);
        Assertions.assertEquals(1,cart.getItems().size());
        Assertions.assertEquals(300,cart.getTotalPrice());

        cart.decrement(2L);
        Assertions.assertEquals(1,cart.getItems().size());
        Assertions.assertEquals(300,cart.getTotalPrice());

        cart.decrement(1L);
        Assertions.assertEquals(1,cart.getItems().size());
        Assertions.assertEquals(200,cart.getTotalPrice());

        cart.decrement(1L);
        cart.decrement(1L);
        Assertions.assertEquals(0,cart.getItems().size());
        Assertions.assertEquals(0,cart.getTotalPrice());
    }

    @Test
    void remove() {
        cart.add(product2);
        cart.add(product2);
        Assertions.assertEquals(1,cart.getItems().size());
        Assertions.assertEquals(100,cart.getTotalPrice());

        cart.remove(2L);
        Assertions.assertEquals(0,cart.getItems().size());
        Assertions.assertEquals(0,cart.getTotalPrice());
    }

    @Test
    void clear() {
        cart.add(product1);
        cart.add(product2);
        Assertions.assertEquals(2,cart.getItems().size());
        Assertions.assertEquals(150,cart.getTotalPrice());

        cart.clear();
        Assertions.assertEquals(0,cart.getItems().size());
        Assertions.assertEquals(0,cart.getTotalPrice());
    }

    @Test
    void merge() {
        cart.add(product1);
        Assertions.assertEquals(1,cart.getItems().size());
        Assertions.assertEquals(100,cart.getTotalPrice());

        Cart anotherCart = new Cart();
        anotherCart.add(product1);
        anotherCart.add(product2);
        Assertions.assertEquals(2,anotherCart.getItems().size());
        Assertions.assertEquals(150,anotherCart.getTotalPrice());

        cart.merge(anotherCart);
        Assertions.assertEquals(2,cart.getItems().size());
        Assertions.assertEquals(250,cart.getTotalPrice());
    }
}
