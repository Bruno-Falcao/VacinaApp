package com.example.vacinaapp.services;

import com.example.vacinaapp.models.Professional;
import com.example.vacinaapp.repositories.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProfissionalService {

    @Autowired
    private ProfessionalRepository profissionalRepository;


    public ResponseEntity updateProfessional(Professional professional) {
        try {
            return ResponseEntity.ok().body(profissionalRepository.save(professional));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    public ResponseEntity findAllProfessionals() {
        try {
            return ResponseEntity.ok().body(profissionalRepository.findAll());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    public ResponseEntity findProfessionalById(Integer id) {
        try {
            return ResponseEntity.ok().body(profissionalRepository.findById(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    public ResponseEntity deleteProfessional(Professional professional) {
        try {
            profissionalRepository.delete(professional);

            return ResponseEntity.ok().body("Professional delete with success");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
