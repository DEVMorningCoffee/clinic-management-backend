package com.example.demo.exception;

import java.io.Serial;

public class InternalErrorException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 4L;
    public InternalErrorException(String message) {
        super(message);
    }
}
