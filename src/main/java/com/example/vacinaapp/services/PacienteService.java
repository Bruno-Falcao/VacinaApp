package com.example.vacinaapp.services;

import com.example.vacinaapp.models.Patient;
import com.example.vacinaapp.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PatientRepository patientRepository;

    public ResponseEntity salvaPaciente(Patient patient) {
        try {
            return ResponseEntity.ok().body(patientRepository.save(patient));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    public ResponseEntity findAllPatients() {
        try {
            return ResponseEntity.ok().body(patientRepository.findAll());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    public ResponseEntity findPatientsById(Integer id) {
        try {
            return ResponseEntity.ok().body(patientRepository.findById(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    public ResponseEntity deletePatient(Patient patient) {
        try {
            patientRepository.delete(patient);

            return ResponseEntity.ok().body("Patient deleted with success");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
