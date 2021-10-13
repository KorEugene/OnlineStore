package ru.geekbrains.springwebappjs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.springwebappjs.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
