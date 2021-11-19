package com.example.vacinaapp.services;

import com.example.vacinaapp.controllers.VacinacaoController;
import com.example.vacinaapp.models.Profissional;
import com.example.vacinaapp.models.Vacinacao;
import com.example.vacinaapp.repositories.VacinacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VacinacaoService {

    @Autowired
    private VacinacaoRepository vacinacaoRepository;


    public ResponseEntity salvaVacinacao(Vacinacao vacinacao) {
        try {
            return ResponseEntity.ok().body(vacinacaoRepository.save(vacinacao));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    public ResponseEntity buscaTodasVacinacoes() {
        try {
            return ResponseEntity.ok().body(vacinacaoRepository.findAll());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    public ResponseEntity buscaVacinacaoPorId(Integer id) {
        try {
            return ResponseEntity.ok().body(vacinacaoRepository.findById(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    public ResponseEntity deletaVacinacao(Vacinacao vacinacao) {
        try {
            vacinacaoRepository.delete(vacinacao);

            return ResponseEntity.ok().body("Vacinacao deletada com sucesso");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
