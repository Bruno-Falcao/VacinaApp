package com.example.vacinaapp.controllers;

import com.example.vacinaapp.models.Vaccination;
import com.example.vacinaapp.services.VaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vaccination")
public class VaccinationController {

    @Autowired
    private VaccinationService vaccinationService;

    @PostMapping("/register")
    public ResponseEntity salvaVacina(@RequestBody Vaccination vaccination) {
        try {
            return vaccinationService.saveVaccination(vaccination);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping("/register")
    public ResponseEntity updateVaccination(@RequestBody Vaccination vaccination) {
        try {
            return vaccinationService.saveVaccination(vaccination);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("find-vaccination")
    public ResponseEntity findVaccination(@RequestParam(required = false) Integer id) {
        try {
            if (id != null) {
                return vaccinationService.buscaVacinacaoPorId(id);
            }
            return vaccinationService.buscaTodasVacinacoes();

        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/delete-vaccination")
    public ResponseEntity deleteVaccination(@RequestBody Vaccination vaccination) {
        try {
            return vaccinationService.deleteVaccination(vaccination);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
