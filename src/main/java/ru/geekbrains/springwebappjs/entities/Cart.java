package ru.geekbrains.springwebappjs.entities;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class Cart {

    private List<Product> productList;

    public Cart() {
        productList = new ArrayList<>();
    }
}
