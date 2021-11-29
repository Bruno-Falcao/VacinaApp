package com.example.vacinaapp.controllers;

import com.example.vacinaapp.models.Patient;
import com.example.vacinaapp.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("patient")
public class PatientController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/register")
    public ResponseEntity cadastraPaciente(@RequestBody Patient patient) {
        try {
            return pacienteService.salvaPaciente(patient);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping("/register")
    public ResponseEntity alterarOrg(@RequestBody Patient patient) {
        try {
            return pacienteService.salvaPaciente(patient);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/find-patient")
    public ResponseEntity findPatients(@RequestParam(required = false) Integer id) {
        try {
            if (id != null) {
                return pacienteService.findPatientsById(id);
            }
            return pacienteService.findAllPatients();

        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/delete-paciente")
    public ResponseEntity deletaOrg(@RequestBody Patient patient) {
        try {
            return pacienteService.deletePatient(patient);

        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
