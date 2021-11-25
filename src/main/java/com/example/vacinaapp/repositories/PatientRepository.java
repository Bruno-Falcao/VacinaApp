package com.example.vacinaapp.repositories;

import com.example.vacinaapp.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

}