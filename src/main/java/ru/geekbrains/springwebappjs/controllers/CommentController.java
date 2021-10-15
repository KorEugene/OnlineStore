package ru.geekbrains.springwebappjs.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.springwebappjs.dtos.CommentRequestDto;
import ru.geekbrains.springwebappjs.dtos.CommentResponseDto;
import ru.geekbrains.springwebappjs.exceptions.DataValidationException;
import ru.geekbrains.springwebappjs.services.CommentService;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public CommentResponseDto saveComment(@RequestBody @Validated CommentRequestDto request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new DataValidationException(bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList()));
        }
        return new CommentResponseDto(commentService.save(request));
    }
}
