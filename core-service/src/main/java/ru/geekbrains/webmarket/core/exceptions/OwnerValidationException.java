package ru.geekbrains.webmarket.core.exceptions;

public class OwnerValidationException extends RuntimeException {
    private static final String NOT_OWNER = "Вы не можете оставлять комментарии, так как ещё не покупали данный продукт";

    public OwnerValidationException() {
        super(NOT_OWNER);
    }
}
