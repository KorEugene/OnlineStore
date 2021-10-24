package ru.geekbrains.webmarket.api.dtos;

import java.util.List;

public class ProductDetailsDto {

    private String title;
    private int price;
    private String categoryTitle;
    private List<CommentResponseDto> commentList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public List<CommentResponseDto> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentResponseDto> commentList) {
        this.commentList = commentList;
    }

    public ProductDetailsDto() {
    }
}
