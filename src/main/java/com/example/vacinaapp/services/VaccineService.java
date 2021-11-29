package com.example.vacinaapp.services;

import com.example.vacinaapp.models.Vaccine;
import com.example.vacinaapp.repositories.VaccinneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VaccineService {

    @Autowired
    private VaccinneRepository vaccinneRepository;


    public ResponseEntity saveVaccine(Vaccine vaccine) {
        try {
            return ResponseEntity.ok().body(vaccinneRepository.save(vaccine));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    public ResponseEntity findAllVaccines() {
        try {
            return ResponseEntity.ok().body(vaccinneRepository.findAll());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    public ResponseEntity findVaccineById(Integer id) {
        try {
            return ResponseEntity.ok().body(vaccinneRepository.findById(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    public ResponseEntity deleteVaccine(Vaccine vaccine) {
        try {
            vaccinneRepository.delete(vaccine);

            return ResponseEntity.ok().body("vaccine deleted with success");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
