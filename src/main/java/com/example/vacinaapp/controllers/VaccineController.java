package com.example.vacinaapp.controllers;

import com.example.vacinaapp.models.Vaccine;
import com.example.vacinaapp.services.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vaccine")
public class VaccineController {

    @Autowired
    private VaccineService vaccineService;

    @PostMapping("/register")
    public ResponseEntity saveVaccine(@RequestBody Vaccine vaccine) {
        try {
            return vaccineService.saveVaccine(vaccine);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping("/register")
    public ResponseEntity updateVaccine(@RequestBody Vaccine vaccine) {
        try {
            return vaccineService.saveVaccine(vaccine);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("find-vaccine")
    public ResponseEntity findVaccines(@RequestParam(required = false) Integer id) {
        try {
            if (id != null) {
                return vaccineService.findVaccineById(id);
            }
            return vaccineService.findAllVaccines();

        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/delete-vaccine")
    public ResponseEntity deleteVaccine(@RequestBody Vaccine vaccine) {
        try {
            return vaccineService.deleteVaccine(vaccine);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
