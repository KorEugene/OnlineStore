package ru.geekbrains.springwebappjs.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.springwebappjs.dtos.UserRegistrationRequestDto;
import ru.geekbrains.springwebappjs.dtos.UserRegistrationResponseDto;
import ru.geekbrains.springwebappjs.entities.User;
import ru.geekbrains.springwebappjs.exceptions.DataValidationException;
import ru.geekbrains.springwebappjs.services.UserService;

import java.util.Collections;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/registration")
@RequiredArgsConstructor
public class RegistrationController {
    private final UserService userService;

    @PostMapping
    public UserRegistrationResponseDto save(@RequestBody @Validated UserRegistrationRequestDto userRegistrationRequestDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new DataValidationException(bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList()));
        }
        if (!userRegistrationRequestDto.getPassword().equals(userRegistrationRequestDto.getConfirm())) {
            throw new DataValidationException(Collections.singletonList("Введенные пароли не совпадают"));
        }
        if (userService.findByUsername(userRegistrationRequestDto.getUsername()).isPresent()) {
            throw new DataValidationException(Collections.singletonList("Пользователь с таким именем уже существует"));
        }
        User user = userService.saveUser(new User(userRegistrationRequestDto.getUsername(), userRegistrationRequestDto.getPassword()));
        return new UserRegistrationResponseDto(user);
    }
}
