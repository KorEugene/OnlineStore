package ru.geekbrains.webmarket.api.dtos;

public class CommentResponseDto {

    private String username;

    private String createdAt;

    private String content;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CommentResponseDto() {
    }

    public CommentResponseDto(String username, String createdAt, String content) {
        this.username = username;
        this.createdAt = createdAt;
        this.content = content;
    }
}
