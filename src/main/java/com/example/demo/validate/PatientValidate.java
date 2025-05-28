package com.example.demo.validate;

import com.example.demo.entity.Patient;
import com.example.demo.exception.DuplicatePatientException;
import com.example.demo.exception.InvalidInputException;
import com.example.demo.exception.MissingFieldException;
import com.example.demo.repository.PatientRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PatientValidate {
    private static final String NAME_REGEX = "^[a-zA-Z'-]+$";
    private static final String USERNAME_REGEX = "^[a-zA-Z0-9_]+$";
    private static final String PASSWORD_REGEX = "^[a-zA-Z0-9_]+$";

    public void validatePatient(@NotNull Patient patient) {
        validateDOB(patient.getDateOfBirth());
        validatePassword(patient.getPassword());
        validateUsername(patient.getUsername());
        validatePatientName(patient.getFirstName(), patient.getLastName());
    }

    public void validatePatientName(@NotNull String firstName, @NotNull String lastName) {
        // Only allows for letters, dashes and apostrophes for names
        if (!firstName.matches(NAME_REGEX)) {
            throw new InvalidInputException("First name must contain only letters, apostrophes, or dashes and cannot be null");
        }

        if (!lastName.matches(NAME_REGEX)) {
            throw new InvalidInputException("Last name must contain only letters, apostrophes, or dashes and cannot be null");
        }
    }

    public void validateDOB(LocalDate dob) {
        if(!LocalDate.now().isAfter(dob)){
            throw new InvalidInputException("Date of birth must be in the past");
        }
    }

    public void validateUsername(@NotNull String username) {
        if(!username.matches(USERNAME_REGEX)){
            throw new InvalidInputException("Username must contain only letters, numbers and underscores");
        }
    }

    public void validatePassword(@NotNull String password){
        if(!password.matches(PASSWORD_REGEX)){
            throw new InvalidInputException("Password must contain only letters, numbers and underscores");
        }

        if(password.length() < 8){
            throw new InvalidInputException("Password must be at least 8 characters");
        }
    }
}
