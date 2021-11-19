package com.example.vacinaapp.controllers;

import com.example.vacinaapp.models.Organigacao;
import com.example.vacinaapp.services.OrganigacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("org")
public class OrganizacaoController {

    @Autowired
    private OrganigacaoService orgService;

    @PostMapping("/cadastrar")
    public ResponseEntity cadastraOrg(@RequestBody Organigacao org) {
        try {
            return orgService.salvaOrganigacao(org);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping("/cadastrar")
    public ResponseEntity alterarOrg(@RequestBody Organigacao org) {
        try {
            return orgService.salvaOrganigacao(org);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/busca-orgs")
    public ResponseEntity buscaOrgs(@RequestParam(required = false) Integer id) {
        try {
            if (id != null) {
                return orgService.pegaOrganigacaoPorId(id);
            }
            return orgService.pegaOrganigacoes();

        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/deleta-org")
    public ResponseEntity deletaOrg(@RequestBody Organigacao org) {
        try {
            return orgService.deletaOrg(org);

        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
