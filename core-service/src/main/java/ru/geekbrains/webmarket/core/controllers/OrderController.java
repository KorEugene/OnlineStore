package ru.geekbrains.webmarket.core.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.webmarket.api.dtos.OrderDetailsDto;
import ru.geekbrains.webmarket.api.dtos.OrderDto;
import ru.geekbrains.webmarket.core.services.OrderService;
import ru.geekbrains.webmarket.core.utils.Converter;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
@CrossOrigin("*")
public class OrderController {
    private final OrderService orderService;
    private final Converter converter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody OrderDetailsDto orderDetailsDto, @RequestHeader String username) {
        orderService.createOrder(username, orderDetailsDto);
    }

    @GetMapping
    public List<OrderDto> getOrdersForCurrentUser(@RequestHeader String username) {
        return orderService.findAllByUsername(username).stream().map(converter::orderToDto).collect(Collectors.toList());
    }
}
