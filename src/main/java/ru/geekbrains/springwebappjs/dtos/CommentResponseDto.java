package ru.geekbrains.springwebappjs.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.springwebappjs.entities.Comment;
import ru.geekbrains.springwebappjs.utils.DateTimeProcessor;

@Data
@NoArgsConstructor
public class CommentResponseDto {

    private String username;

    private String createdAt;

    private String content;

    public CommentResponseDto(Comment comment) {
        this.username = comment.getUser().getUsername();
        this.createdAt = DateTimeProcessor.formatLocalDateTime(comment.getCreatedAt());
        this.content = comment.getContent();
    }
}
