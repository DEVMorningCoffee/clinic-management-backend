package com.example.demo.service;

import com.example.demo.dto.PatientDTO;
import com.example.demo.entity.Patient;
import com.example.demo.repository.PatientRepository;
import com.example.demo.validate.PatientValidate;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

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

    public Patient updateMedicalInfo(PatientDTO patient, UUID id) {
        // Check if User exist
        patientValidate.validateUsernameExists(patient.getUsername());

        Patient retrievePatient = patientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Patient not found"));

        retrievePatient.setMedicalInfo(patient.getMedicalInfo());

        return patientRepository.save(retrievePatient);
    }

    public Patient updateContactInfo(PatientDTO patient, UUID id) {
        // Check if User exist
        patientValidate.validateUsernameExists(patient.getUsername());

        Patient retrievePatient = patientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Patient not found"));

        retrievePatient.setContactInfo(patient.getContactInfo());

        return patientRepository.save(retrievePatient);
    }

    public Patient updateFirstName(PatientDTO patient, UUID id) {
        // Check if User exist
        patientValidate.validateUsernameExists(patient.getUsername());
        patientValidate.validateFirstName(patient.getFirstName());

        Patient retrievePatient = patientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Patient not found"));

        retrievePatient.setFirstName(patient.getFirstName());

        return patientRepository.save(retrievePatient);
    }

    public Patient updateLastName(PatientDTO patient, UUID id) {
        // Check if User exist
        patientValidate.validateUsernameExists(patient.getUsername());
        patientValidate.validateLastName(patient.getLastName());

        Patient retrievePatient = patientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Patient not found"));

        retrievePatient.setLastName(patient.getLastName());

        return patientRepository.save(retrievePatient);
    }

    public Patient updateDateOfBirth(PatientDTO patient, UUID id) {
        // Check if User exist
        patientValidate.validateUsernameExists(patient.getUsername());
        patientValidate.validateDOB(patient.getDateOfBirth());

        Patient retrievePatient = patientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Patient not found"));

        retrievePatient.setDateOfBirth(patient.getDateOfBirth());

        return patientRepository.save(retrievePatient);
    }

    public Patient updateGender(PatientDTO patient, UUID id) {
        // Check if User exist
        patientValidate.validateUsernameExists(patient.getUsername());

        Patient retrievePatient = patientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Patient not found"));

        retrievePatient.setGender(patient.getGender());

        return patientRepository.save(retrievePatient);
    }

    public Patient updatePassword(Patient patient, UUID id) {
        // Check if User exist
        patientValidate.validateUsernameExists(patient.getUsername());
        patientValidate.validatePassword(patient.getPassword());

        Patient retrievePatient = patientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Patient not found"));

        retrievePatient.setPassword(patient.getPassword());

        return patientRepository.save(retrievePatient);
    }

    public Patient updatePatient(Patient patient, UUID id) {
        // Check if User exist
        patientValidate.validatePatient(patient);

        Patient retrievePatient = patientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Patient not found"));

        retrievePatient.setUsername(patient.getUsername());
        retrievePatient.setPassword(patient.getPassword());
        retrievePatient.setFirstName(patient.getFirstName());
        retrievePatient.setLastName(patient.getLastName());
        retrievePatient.setGender(patient.getGender());
        retrievePatient.setMedicalInfo(patient.getMedicalInfo());
        retrievePatient.setDateOfBirth(patient.getDateOfBirth());
        retrievePatient.setContactInfo(patient.getContactInfo());

        return patientRepository.save(retrievePatient);
    }



    public Patient accessPatient(Patient patient) {
        patientValidate.validateUsernameExists(patient.getUsername());
        patientValidate.validatePassword(patient.getPassword());

        return patientRepository.findByUsernameAndPassword(patient.getUsername(), patient.getPassword())
                .orElseThrow(() -> new EntityNotFoundException("Patient not found"));
    }


}
