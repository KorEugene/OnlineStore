package ru.geekbrains.springwebappjs.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.springwebappjs.entities.Cart;
import ru.geekbrains.springwebappjs.entities.Product;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {

    private Cart cart;

    @Autowired
    public CartService(Cart cart) {
        this.cart = cart;
    }

    public List<Product> getProducts() {
        return cart.getProductList();
    }

    public void addProduct(Product product) {
        cart.getProductList().add(product);
    }

    public void removeProductById(Long id) {
        Optional<Product> optionalProduct = findProductById(id);
        optionalProduct.ifPresent(product -> cart.getProductList().remove(product));
    }

    public Optional<Product> findProductById(Long productId) {
        return cart.getProductList().stream()
                .filter(product -> product.getId().equals(productId)).findFirst();
    }
}
