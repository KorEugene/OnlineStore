package ru.geekbrains.webmarket.api.dtos;

//import org.hibernate.validator.constraints.Length;

//import javax.validation.constraints.NotBlank;

public class CommentRequestDto {

    private Long productId;

    private String username;

//    @NotBlank(message = "Комментарий не может быть пустым")
//    @Length(max = 255, message = "Длина комментария должна составлять не более 255 символов")
    private String content;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CommentRequestDto() {
    }

    public CommentRequestDto(Long productId, String username, String content) {
        this.productId = productId;
        this.username = username;
        this.content = content;
    }
}
