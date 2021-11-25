package com.example.vacinaapp.controllers;

import com.example.vacinaapp.models.Professional;
import com.example.vacinaapp.services.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("professional")
public class ProfessionalController {

    @Autowired
    private ProfissionalService profissionalService;

    @PostMapping("/register")
    public ResponseEntity saveProfessional(@RequestBody Professional professional) {
        try {
            return profissionalService.updateProfessional(professional);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping("/register")
    public ResponseEntity updateProfessional(@RequestBody Professional professional) {
        try {
            return profissionalService.updateProfessional(professional);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("find-professional")
    public ResponseEntity findProfessional(@RequestParam(required = false) Integer id) {
        try {
            if (id != null) {
                return profissionalService.findProfessionalById(id);
            }
            return profissionalService.findAllProfessionals();

        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/deleta-professional")
    public ResponseEntity deleteProfessional(@RequestBody Professional professional) {
        try {
            return profissionalService.deleteProfessional(professional);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
