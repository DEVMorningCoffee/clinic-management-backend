package com.example.demo.repository;

import com.example.demo.entity.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {
    @Query("SELECT p FROM patient p WHERE p.username = :username")
    Optional<Patient> findByUsername(@Param("username") String username);


    @Transactional
    @Modifying
    @Query("UPDATE patient p SET p.medicalInfo = :medicalInfo WHERE p.username = :username")
    int updatePatientMedicalInfo(@Param("medicalInfo") String medicalInfo, @Param("username") String username);
}
