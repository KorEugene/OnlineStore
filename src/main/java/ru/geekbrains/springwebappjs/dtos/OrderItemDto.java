package ru.geekbrains.springwebappjs.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.springwebappjs.entities.OrderItem;
import ru.geekbrains.springwebappjs.entities.ProductEntity;

@Data
@NoArgsConstructor
public class OrderItemDto {
    private Long productId;
    private String productTitle;
    private int quantity;
    private int pricePerProduct;
    private int price;

    public OrderItemDto(ProductEntity productEntity) {
        this.productId = productEntity.getId();
        this.productTitle = productEntity.getTitle();
        this.quantity = 1;
        this.price = productEntity.getPrice();
        this.pricePerProduct = productEntity.getPrice();
    }

    public OrderItemDto(OrderItem orderItem) {
        this.productId = orderItem.getProductEntity().getId();
        this.productTitle = orderItem.getProductEntity().getTitle();
        this.quantity = orderItem.getQuantity();
        this.price = orderItem.getPrice();
        this.pricePerProduct = orderItem.getPricePerProduct();
    }

    public void changeQuantity(int delta) {
        quantity += delta;
        if (quantity < 0) {
            quantity = 0;
        }
        price = pricePerProduct * quantity;
    }
}
