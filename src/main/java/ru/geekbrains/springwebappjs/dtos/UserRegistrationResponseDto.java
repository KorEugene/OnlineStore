package ru.geekbrains.springwebappjs.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.springwebappjs.entities.User;

@NoArgsConstructor
@Data
public class UserRegistrationResponseDto {
    private String username;

    public UserRegistrationResponseDto(User user) {
        this.username = user.getUsername();
    }
}
