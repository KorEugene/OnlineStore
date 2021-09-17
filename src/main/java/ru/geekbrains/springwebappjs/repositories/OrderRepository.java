package ru.geekbrains.springwebappjs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.springwebappjs.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
