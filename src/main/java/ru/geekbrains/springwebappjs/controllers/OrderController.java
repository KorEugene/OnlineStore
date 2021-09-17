package ru.geekbrains.springwebappjs.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.springwebappjs.dtos.OrderDetailsDto;
import ru.geekbrains.springwebappjs.entities.Order;
import ru.geekbrains.springwebappjs.services.CartService;
import ru.geekbrains.springwebappjs.services.OrderService;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final CartService cartService;
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody OrderDetailsDto orderDetailsDto) {
        Order order = new Order(orderDetailsDto);
        orderService.saveOrder(order);
        cartService.clearCart();
    }
}
