package com.example.vacinaapp.controllers;

import com.example.vacinaapp.models.Profissional;
import com.example.vacinaapp.models.Vacina;
import com.example.vacinaapp.services.ProfissionalService;
import com.example.vacinaapp.services.VacinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("profissional")
public class ProfissionalController {
    @Autowired
    private ProfissionalService profissionalService;

    @PostMapping("/cadastrar")
    public ResponseEntity salvaVacina(@RequestBody Profissional profissional) {
        try {
            return profissionalService.salvaProfissional(profissional);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping("/cadastrar")
    public ResponseEntity alteraVacina(@RequestBody Profissional profissional) {
        try {
            return profissionalService.salvaProfissional(profissional);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("busca-profissional")
    public ResponseEntity pegaVacinas(@RequestParam(required = false) Integer id) {
        try {
            if (id != null) {
                return profissionalService.buscaProfissionalPorId(id);
            }
            return profissionalService.buscaTodosProfissionais();

        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/deleta-profissional")
    public ResponseEntity deletaVacina(@RequestBody Profissional profissional) {
        try {
            return profissionalService.deletaProfissional(profissional);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
