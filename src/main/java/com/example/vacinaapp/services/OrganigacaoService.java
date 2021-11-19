package com.example.vacinaapp.services;

import com.example.vacinaapp.models.Organigacao;
import com.example.vacinaapp.repositories.OrganigacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrganigacaoService {

    @Autowired
    private OrganigacaoRepository orgRepository;


    public ResponseEntity salvaOrganigacao(Organigacao org) {
        try {
            return ResponseEntity.ok().body(orgRepository.save(org));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    public ResponseEntity pegaOrganigacoes() {
        try {
            return ResponseEntity.ok().body(orgRepository.findAll());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    public ResponseEntity pegaOrganigacaoPorId(Integer id) {
        try {
            return ResponseEntity.ok().body(orgRepository.findById(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    public ResponseEntity deletaOrg(Organigacao org) {
        try {
            orgRepository.delete(org);
            return ResponseEntity.ok().body("Organização deletada com sucesso!");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
