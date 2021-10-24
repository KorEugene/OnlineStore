package ru.geekbrains.webmarket.core.utils;

import org.springframework.stereotype.Component;
import ru.geekbrains.webmarket.api.dtos.*;
import ru.geekbrains.webmarket.core.entities.*;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Converter {
    public ProductDto productToDto(ProductEntity product) {
        return new ProductDto(product.getId(), product.getTitle(), product.getPrice(), product.getCategoryEntity().getTitle());
    }

    public CategoryDto categoryToDto(CategoryEntity category) {
        List<ProductDto> products = category.getProductEntities().stream().map(this::productToDto).collect(Collectors.toList());
        return new CategoryDto(category.getId(), category.getTitle(), products);
    }

    public OrderItemDto orderItemToDto(OrderItem orderItem) {
        return new OrderItemDto(orderItem.getProductEntity().getId(), orderItem.getProductEntity().getTitle(), orderItem.getQuantity(), orderItem.getPricePerProduct(), orderItem.getPrice());
    }

    public OrderDto orderToDto(Order order) {
        return new OrderDto(order.getId(), order.getItems().stream().map(this::orderItemToDto).collect(Collectors.toList()), order.getAddress(), order.getPhone(), order.getPrice());
    }

    public CommentResponseDto commentToCommentResponseDto(Comment comment) {
        return new CommentResponseDto(comment.getId().toString(), DateTimeProcessor.formatLocalDateTime(comment.getCreatedAt()), comment.getContent());
    }
}
