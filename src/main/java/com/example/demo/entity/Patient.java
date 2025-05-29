package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Table(name = "patient")
@Entity(name = "patient")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Patient {

    public enum Gender{
        MALE,
        FEMALE,
        OTHER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID patientId;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "date_of_birth", nullable = false)
    @JsonFormat(pattern = "MM-dd-yyyy")
    private LocalDate dateOfBirth;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "username", nullable = false, unique = true, length = 25)
    private String username;

    @Column(name = "password", nullable = false, length = 35)
    private String password;

    @Column(name = "contact_info")
    private String contactInfo;

    @Column(name = "medical_info")
    private String medicalInfo;

    public Patient(String firstName, String lastName, Gender gender, String username, String password, String contactInfo, String medicalInfo) {
        // Use to create patient
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.username = username;
        this.password = password;
        this.contactInfo = contactInfo;
        this.medicalInfo = medicalInfo;
    }

    public Patient(String username, String firstName, String lastName){
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Patient(String username, String firstName, String lastName, String medicalInfo){
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.medicalInfo = medicalInfo;
    }
}
