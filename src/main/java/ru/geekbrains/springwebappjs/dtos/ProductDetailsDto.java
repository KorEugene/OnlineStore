package ru.geekbrains.springwebappjs.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ProductDetailsDto {

    private String title;

    private int price;

    private String categoryTitle;

    private List<CommentResponseDto> commentList;
}
