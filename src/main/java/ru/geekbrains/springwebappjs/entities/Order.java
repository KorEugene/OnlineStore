package ru.geekbrains.springwebappjs.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.springwebappjs.dtos.OrderDetailsDto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<OrderItem> orderItems;

    public Order(OrderDetailsDto orderDetailsDto) {
        this.phone = orderDetailsDto.getPhone();
        this.address = orderDetailsDto.getAddress();
    }
}
