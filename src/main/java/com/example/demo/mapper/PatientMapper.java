package com.example.demo.mapper;

import com.example.demo.dto.PatientDTO;
import com.example.demo.entity.Patient;

public class PatientMapper {
    public static PatientDTO toDTO(Patient patient) {
        return new PatientDTO(
                patient.getPatientId(),
                patient.getFirstName(),
                patient.getLastName(),
                patient.getUsername(),
                patient.getMedicalInfo(),
                patient.getDateOfBirth(),
                patient.getGender()
        );
    }

    public static Patient toEntity(PatientDTO dto) {
        Patient patient = new Patient();
        patient.setPatientId(dto.getPatientId());
        patient.setFirstName(dto.getFirstName());
        patient.setLastName(dto.getLastName());
        patient.setUsername(dto.getUsername());
        patient.setMedicalInfo(dto.getMedicalInfo());
        patient.setDateOfBirth(dto.getDateOfBirth());
        patient.setGender(dto.getGender());
        return patient;
    }
}
