package ru.geekbrains.webmarket.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.geekbrains.webmarket.api.exceptions.MarketError;
import ru.geekbrains.webmarket.api.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> catchResourceNotFoundException(ResourceNotFoundException e) {
        return new ResponseEntity<>(new MarketError(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<?> catchValidationException(DataValidationException e) {
        return new ResponseEntity<>(new MarketError(e.getMessages()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<?> catchOwnerValidationException(OwnerValidationException e) {
        return new ResponseEntity<>(new MarketError(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}