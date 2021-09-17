package ru.geekbrains.springwebappjs.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.springwebappjs.entities.Order;
import ru.geekbrains.springwebappjs.entities.OrderItem;
import ru.geekbrains.springwebappjs.repositories.OrderRepository;
import ru.geekbrains.springwebappjs.utils.Cart;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartService cartService;
    private final ProductService productService;

    @Transactional
    public void saveOrder(Order order) {
        Cart currentCart = cartService.getCartForCurrentUser();
        List<Long> productIds = new ArrayList<>();
        currentCart.getItems().forEach(orderItemDto -> productIds.add(orderItemDto.getProductId()));


        List<OrderItem> orderItems = cartService.getCartForCurrentUser().getItems().stream()
                .map(oidto -> new OrderItem(productService.findById(oidto.getProductId()).get(), oidto.getQuantity(), oidto.getPricePerProduct(), oidto.getPrice()))
                .collect(Collectors.toList());

        order.setOrderItems(orderItems);

        orderRepository.save(order);
    }
}
