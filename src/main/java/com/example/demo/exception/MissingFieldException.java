package com.example.demo.exception;

import java.io.Serial;

public class MissingFieldException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 2L;

    public MissingFieldException(String message) {
        super(message);
    }
}
