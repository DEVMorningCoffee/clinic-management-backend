package com.example.demo.exception;

import java.io.Serial;

public class InvalidInputException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 3L;

    public InvalidInputException(String message) {
        super(message);
    }
}
