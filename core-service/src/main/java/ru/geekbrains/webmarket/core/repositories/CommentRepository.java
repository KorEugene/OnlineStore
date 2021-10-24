package ru.geekbrains.webmarket.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.webmarket.core.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
