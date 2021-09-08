package ru.geekbrains.springwebappjs.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.springwebappjs.dtos.OrderDetailsDto;
import ru.geekbrains.springwebappjs.services.CartService;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final CartService cartService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody OrderDetailsDto orderDetailsDto) {

        cartService.clearCart();
    }
}
