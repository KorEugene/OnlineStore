package ru.geekbrains.springwebappjs.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class CommentRequestDto {

    private Long productId;

    private String username;

    @NotBlank(message = "Комментарий не может быть пустым")
    @Length(max = 255, message = "Длина комментария должна составлять не более 255 символов")
    private String content;
}
