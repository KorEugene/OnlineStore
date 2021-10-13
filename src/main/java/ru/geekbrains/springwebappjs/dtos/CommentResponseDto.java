package ru.geekbrains.springwebappjs.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.springwebappjs.entities.Comment;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CommentResponseDto {

    private String username;

    private LocalDateTime createdAt;

    private String content;

    public CommentResponseDto(Comment comment) {
        this.username = comment.getUser().getUsername();
        this.createdAt = comment.getCreatedAt();
        this.content = comment.getContent();
    }
}
