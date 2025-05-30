package com.example.demo.controller;

import com.example.demo.dto.PatientDTO;
import com.example.demo.entity.Patient;
import com.example.demo.mapper.PatientMapper;
import com.example.demo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/api/patient")
public class PatientController {
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> createPatient(@Validated @RequestBody Patient patient) {
        Patient newPatient = patientService.registerPatient(patient);
        return new ResponseEntity<>(PatientMapper.toDTO(newPatient), HttpStatus.CREATED);
    }

    @PostMapping(value="/login")
    public ResponseEntity<?> loginPatient(@Validated @RequestBody Patient patient) {
        Patient retrievePatient = patientService.accessPatient(patient);

        return new ResponseEntity<>(PatientMapper.toDTO(retrievePatient), HttpStatus.OK);
    }

    @PatchMapping(value = "/medical/{id}/update")
    public ResponseEntity<?> updateMedicalInfo(@Validated @RequestBody PatientDTO patient, @PathVariable UUID id) {
        Patient updatedPatient = patientService.updateMedicalInfo(patient, id);

        return new ResponseEntity<>(PatientMapper.toDTO(updatedPatient), HttpStatus.OK);
    }

    @PatchMapping(value = "/contact/{id}/update")
    public ResponseEntity<?> updateContactInfo(@Validated @RequestBody PatientDTO patient, @PathVariable UUID id) {
        Patient updatePatient = patientService.updateContactInfo(patient, id);

        return new ResponseEntity<>(PatientMapper.toDTO(updatePatient), HttpStatus.OK);
    }

}
