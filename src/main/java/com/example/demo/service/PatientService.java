package com.example.demo.service;

import com.example.demo.entity.Patient;
import com.example.demo.exception.DuplicatePatientException;
import com.example.demo.repository.PatientRepository;
import com.example.demo.validate.PatientValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    private final PatientValidate patientValidate;

    @Autowired
    public PatientService(PatientRepository patientRepository, PatientValidate patientValidate) {
        this.patientRepository = patientRepository;
        this.patientValidate = patientValidate;
    }

    public Patient registerPatient(Patient patient) {
        patientValidate.validatePatient(patient);

        return patientRepository.save(patient);
    }
}
