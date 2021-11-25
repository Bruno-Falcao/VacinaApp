package com.example.vacinaapp.controllers;

import com.example.vacinaapp.models.Organization;
import com.example.vacinaapp.services.OrganigacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("org")
public class OrganizationController {

    @Autowired
    private OrganigacaoService orgService;

    @PostMapping("/register")
    public ResponseEntity cadastraOrg(@RequestBody Organization org) {
        try {
            return orgService.salvaOrganigacao(org);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping("/register")
    public ResponseEntity alterarOrg(@RequestBody Organization org) {
        try {
            return orgService.salvaOrganigacao(org);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/find-orgs")
    public ResponseEntity buscaOrgs(@RequestParam(required = false) Integer id) {
        try {
            if (id != null) {
                return orgService.findOrgById(id);
            }
            return orgService.findOrgs();

        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/delete-org")
    public ResponseEntity deleteOrg(@RequestBody Organization org) {
        try {
            return orgService.deleteOrg(org);

        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
