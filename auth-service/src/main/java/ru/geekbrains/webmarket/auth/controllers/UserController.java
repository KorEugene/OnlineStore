package ru.geekbrains.webmarket.auth.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.webmarket.api.dtos.ProfileDto;
import ru.geekbrains.webmarket.api.exceptions.ResourceNotFoundException;
import ru.geekbrains.webmarket.auth.entities.User;
import ru.geekbrains.webmarket.auth.services.UserService;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {
    private final UserService userService;

    @GetMapping("/me")
    public ProfileDto aboutCurrentUser(@RequestHeader String username) {
        User user = userService.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("Не удалось найти пользователя. Имя пользователя: " + username));
        return new ProfileDto(user.getUsername(), user.getFirstName(), user.getLastName(), user.getEmail());
    }
}
