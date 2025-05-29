package com.example.demo.dto;


import com.example.demo.entity.Patient;
import lombok.Data;

public record PatientDTO(Patient patient) {

    public Patient createPatientDTO() {
        return new Patient(this.patient.getUsername(), this.patient.getFirstName(), this.patient.getLastName());
    }

    public Patient updatePatientMedicalDTO() {
        return new Patient(this.patient.getUsername(), this.patient.getFirstName(),
                this.patient.getLastName(), this.patient.getMedicalInfo());
    }

}
