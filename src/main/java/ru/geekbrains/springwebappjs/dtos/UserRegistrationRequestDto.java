package ru.geekbrains.springwebappjs.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Data
public class UserRegistrationRequestDto {
    @NotNull(message = "У пользователя должно быть имя")
    private String username;

    @NotNull(message = "Пароль не может быть пустым")
    private String password;

    @NotNull(message = "Введите пароль повторно")
    private String confirm;
}
