package ru.geekbrains.webmarket.core.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.webmarket.api.dtos.CommentRequestDto;
import ru.geekbrains.webmarket.api.dtos.CommentResponseDto;
import ru.geekbrains.webmarket.core.exceptions.DataValidationException;
import ru.geekbrains.webmarket.core.services.CommentService;
import ru.geekbrains.webmarket.core.utils.Converter;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CommentController {
    private final CommentService commentService;
    private final Converter converter;

//    @PostMapping
//    public CommentResponseDto saveComment(@RequestBody @Validated CommentRequestDto request, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            throw new DataValidationException(bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList()));
//        }
//        return converter.commentToCommentResponseDto(commentService.save(request));
//    }
}
