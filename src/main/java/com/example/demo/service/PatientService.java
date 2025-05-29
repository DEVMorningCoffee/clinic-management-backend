package com.example.demo.service;

import com.example.demo.entity.Patient;
import com.example.demo.exception.InternalErrorException;
import com.example.demo.exception.InvalidInputException;
import com.example.demo.repository.PatientRepository;
import com.example.demo.validate.PatientValidate;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Patient updateMedicalInfo(Patient patient) {
        // Check if User exist
        patientValidate.validateUsernameExists(patient.getUsername());

        patientValidate.validateMedicalInfo(patient.getMedicalInfo());

        int updateRow = patientRepository.updatePatientMedicalInfo(patient.getMedicalInfo(), patient.getUsername());

        if(updateRow == 0) {
            throw new InternalErrorException("Something went wrong in our system");
        }

        return patientRepository.findByUsername(patient.getUsername()).orElse(patient);
    }
}
