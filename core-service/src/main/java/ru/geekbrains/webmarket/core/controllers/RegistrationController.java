package ru.geekbrains.webmarket.core.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.webmarket.api.dtos.UserRegistrationRequestDto;
import ru.geekbrains.webmarket.api.dtos.UserRegistrationResponseDto;
//import ru.geekbrains.webmarket.core.entities.User;
import ru.geekbrains.webmarket.core.exceptions.DataValidationException;
//import ru.geekbrains.webmarket.core.services.UserService;

import java.util.Collections;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/registration")
@RequiredArgsConstructor
@CrossOrigin("*")
public class RegistrationController {
//    private final UserService userService;
//
//    @PostMapping
//    public UserRegistrationResponseDto save(@RequestBody @Validated UserRegistrationRequestDto userRegistrationRequestDto, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            throw new DataValidationException(bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList()));
//        }
//        if (!userRegistrationRequestDto.getPassword().equals(userRegistrationRequestDto.getConfirm())) {
//            throw new DataValidationException(Collections.singletonList("Введенные пароли не совпадают"));
//        }
//        if (userService.findByUsername(userRegistrationRequestDto.getUsername()).isPresent()) {
//            throw new DataValidationException(Collections.singletonList("Пользователь с таким именем уже существует"));
//        }
//        User user = userService.saveUser(new User(userRegistrationRequestDto.getUsername(), userRegistrationRequestDto.getPassword()));
//        return new UserRegistrationResponseDto(user.getUsername());
//    }
}
