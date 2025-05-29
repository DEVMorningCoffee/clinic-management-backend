package com.example.demo.controller;

import com.example.demo.dto.PatientDTO;
import com.example.demo.entity.Patient;
import com.example.demo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
        PatientDTO patientDTO = new PatientDTO(newPatient);
        return new ResponseEntity<>(patientDTO.createPatientDTO(), HttpStatus.CREATED);
    }

    @PatchMapping(value = "/medical/update")
    public ResponseEntity<?> updateMedicalInfo(@Validated @RequestBody Patient patient) {
        Patient updatedPatient = patientService.updateMedicalInfo(patient);
        PatientDTO patientDTO = new PatientDTO(updatedPatient);

        return new ResponseEntity<>(patientDTO.updatePatientMedicalDTO(), HttpStatus.OK);
    }

}
