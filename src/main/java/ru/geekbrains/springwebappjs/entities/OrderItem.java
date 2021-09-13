package ru.geekbrains.springwebappjs.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "order_items")
@Data
@NoArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "product_id", referencedColumnName = "id")
//    private Product product;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    private int quantity;

    private int pricePerProduct;

    private int price;

//    public OrderItem(Product product, int quantity, int pricePerProduct, int price) {
//        this.product = product;
//        this.quantity = quantity;
//        this.pricePerProduct = pricePerProduct;
//        this.price = price;
//    }
}
