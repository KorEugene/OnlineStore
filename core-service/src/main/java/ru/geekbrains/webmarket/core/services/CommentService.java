package ru.geekbrains.webmarket.core.services;

import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.webmarket.api.dtos.CommentRequestDto;
import ru.geekbrains.webmarket.api.exceptions.ResourceNotFoundException;
import ru.geekbrains.webmarket.core.entities.Comment;
import ru.geekbrains.webmarket.core.entities.Order;
import ru.geekbrains.webmarket.core.entities.ProductEntity;
//import ru.geekbrains.webmarket.core.entities.User;
import ru.geekbrains.webmarket.core.exceptions.OwnerValidationException;
import ru.geekbrains.webmarket.core.repositories.CommentRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
//    private final CommentRepository commentRepository;
//
//    private final ProductService productService;
//    private final UserService userService;
//    private final OrderService orderService;
//
//    @Transactional
//    public Comment save(CommentRequestDto request) {
//        ProductEntity product = productService.findById(request.getProductId()).orElseThrow(() -> new ResourceNotFoundException("Product id = " + request.getProductId() + " not found"));
//        User user = userService.findByUsername(request.getUsername()).orElseThrow(() -> new UsernameNotFoundException(String.format("User '%s' not found", request.getUsername())));
//
//        Optional<Order> optional = orderService.findAllByUsername(user.getUsername()).stream()
//                .filter(order -> order.getItems().stream().anyMatch(orderItem -> orderItem.getProductEntity().equals(product))).findFirst();
//        if (optional.isEmpty()) {
//            throw new OwnerValidationException();
//        }
//
//        Comment comment = new Comment();
//        comment.setContent(request.getContent());
//        comment.setUser(user);
//        comment.setProductEntity(product);
//
//        return commentRepository.save(comment);
//    }
}
