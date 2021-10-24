package ru.geekbrains.webmarket.api.dtos;

public class UserRegistrationResponseDto {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserRegistrationResponseDto() {
    }

    public UserRegistrationResponseDto(String username) {
        this.username = username;
    }
}
