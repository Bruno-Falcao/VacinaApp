package com.example.vacinaapp.services;

import com.example.vacinaapp.models.Vaccination;
import com.example.vacinaapp.repositories.VaccinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VaccinationService {

    @Autowired
    private VaccinationRepository vaccinationRepository;


    public ResponseEntity saveVaccination(Vaccination vaccination) {
        try {
            return ResponseEntity.ok().body(vaccinationRepository.save(vaccination));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    public ResponseEntity buscaTodasVacinacoes() {
        try {
            return ResponseEntity.ok().body(vaccinationRepository.findAll());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    public ResponseEntity buscaVacinacaoPorId(Integer id) {
        try {
            return ResponseEntity.ok().body(vaccinationRepository.findById(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    public ResponseEntity deleteVaccination(Vaccination vaccination) {
        try {
            vaccinationRepository.delete(vaccination);

            return ResponseEntity.ok().body("Vaccination delete with success");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
