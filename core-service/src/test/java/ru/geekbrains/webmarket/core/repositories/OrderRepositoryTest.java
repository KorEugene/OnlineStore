package ru.geekbrains.webmarket.core.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import ru.geekbrains.webmarket.core.entities.Order;
import ru.geekbrains.webmarket.core.entities.OrderItem;
import ru.geekbrains.webmarket.core.entities.ProductEntity;
import ru.geekbrains.webmarket.core.entities.User;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@DataJpaTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void findAllByUsername() {
        List<Order> orderList = orderRepository.findAllByUsername("user");

        Assertions.assertEquals(1, orderList.size());
        Assertions.assertEquals("Bread", orderList.get(0).getItems().get(0).getProductEntity().getTitle());
        Assertions.assertEquals("user", orderList.get(0).getUser().getUsername());

        ProductEntity productEntity = new ProductEntity();
        Optional<ProductEntity> optionalProduct = productRepository.findById(2L);
        if (optionalProduct.isPresent()) {
            productEntity = optionalProduct.get();
        }

        User user = new User();
        Optional<User> optionalUser = userRepository.findByUsername("user");
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        }

        Order order = new Order();
        order.setAddress("2222");
        order.setPhone("2222");

        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setProductEntity(productEntity);
        orderItem.setPrice(160);
        orderItem.setQuantity(2);
        orderItem.setPricePerProduct(80);

        order.setItems(Collections.singletonList(orderItem));
        order.setPrice(orderItem.getPrice());
        order.setUser(user);

        entityManager.persist(order);
        entityManager.flush();

        orderList = orderRepository.findAllByUsername("user");

        Assertions.assertEquals(2, orderList.size());
        Assertions.assertEquals("Milk", orderList.get(1).getItems().get(0).getProductEntity().getTitle());
        Assertions.assertEquals("user", orderList.get(0).getUser().getUsername());
    }
}
