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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", nullable = false, referencedColumnName = "accountId")
    private Account accountId;

    @Column(name = "contact_info")
    private String contactInfo;

    @Column(name = "medical_info")
    private String medicalInfo;
}
