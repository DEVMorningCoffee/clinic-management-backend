package com.example.demo.exception;


import java.io.Serial;

public class DuplicatePatientException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public DuplicatePatientException(String message) {
        super(message);
    }
}
