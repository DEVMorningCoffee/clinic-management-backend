package com.example.demo.dto;

import com.example.demo.entity.Patient;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class PatientDTO {
    private UUID patientId;
    private String firstName;
    private String lastName;
    private String username;
    private String medicalInfo;
    private LocalDate dateOfBirth;
    private Patient.Gender gender;
    private String contactInfo;

    // Constructors
    public PatientDTO() {}

    // Spring boot works with Jackson by using setters to set contactInfo
    public PatientDTO(UUID patientId, String firstName, String lastName, String username,
                      String medicalInfo, LocalDate dateOfBirth, Patient.Gender gender, String contactInfo) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.medicalInfo = medicalInfo;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contactInfo = contactInfo;
    }

    public PatientDTO(UUID patientId, String firstName, String lastName, String username,
                      String medicalInfo, LocalDate dateOfBirth, Patient.Gender gender) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.medicalInfo = medicalInfo;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }


}
