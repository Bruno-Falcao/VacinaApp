package com.example.vacinaapp.controllers;

import com.example.vacinaapp.models.Vacinacao;
import com.example.vacinaapp.services.VacinacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vacinacao")
public class VacinacaoController {

    @Autowired
    private VacinacaoService vacinacaoService;

    @PostMapping("/cadastrar")
    public ResponseEntity salvaVacina(@RequestBody Vacinacao vacinacao) {
        try {
            return vacinacaoService.salvaVacinacao(vacinacao);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping("/cadastrar")
    public ResponseEntity alteraVacina(@RequestBody Vacinacao vacinacao) {
        try {
            return vacinacaoService.salvaVacinacao(vacinacao);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("busca-vacinacao")
    public ResponseEntity pegaVacinas(@RequestParam(required = false) Integer id) {
        try {
            if (id != null) {
                return vacinacaoService.buscaVacinacaoPorId(id);
            }
            return vacinacaoService.buscaTodasVacinacoes();

        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/deleta-vacinacao")
    public ResponseEntity deletaVacina(@RequestBody Vacinacao vacinacao) {
        try {
            return vacinacaoService.deletaVacinacao(vacinacao);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
