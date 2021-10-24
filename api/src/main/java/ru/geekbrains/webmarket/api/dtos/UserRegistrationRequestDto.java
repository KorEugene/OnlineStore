package ru.geekbrains.webmarket.api.dtos;

//import javax.validation.constraints.NotNull;

public class UserRegistrationRequestDto {
//    @NotNull(message = "У пользователя должно быть имя")
    private String username;

//    @NotNull(message = "Пароль не может быть пустым")
    private String password;

//    @NotNull(message = "Введите пароль повторно")
    private String confirm;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public UserRegistrationRequestDto() {
    }

    public UserRegistrationRequestDto(String username, String password, String confirm) {
        this.username = username;
        this.password = password;
        this.confirm = confirm;
    }
}
