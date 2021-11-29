package com.example.vacinaapp.controllers;

import com.example.vacinaapp.models.Vacina;
import com.example.vacinaapp.services.VacinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vacina")
public class VacinaController {

    @Autowired
    private VacinaService vacinaService;

    @PostMapping("/cadastra")
    public ResponseEntity salvaVacina(@RequestBody Vacina vacina) {
        try {
            return vacinaService.salvaVacina(vacina);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping("/cadastra")
    public ResponseEntity alteraVacina(@RequestBody Vacina vacina) {
        try {
            return vacinaService.salvaVacina(vacina);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("busca-vacina")
    public ResponseEntity pegaVacinas(@RequestParam(required = false) Integer id) {
        try {
            if (id != null) {
                return vacinaService.buscaVacinaPorId(id);
            }
            return vacinaService.buscaTodasVacinas();

        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity deletaVacina(@RequestBody Vacina vacina) {
        try {
            return vacinaService.deletaVacina(vacina);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}