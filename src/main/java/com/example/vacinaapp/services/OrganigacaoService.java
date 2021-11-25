package com.example.vacinaapp.services;

import com.example.vacinaapp.models.Organization;
import com.example.vacinaapp.repositories.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrganigacaoService {

    @Autowired
    private OrganizationRepository orgRepository;


    public ResponseEntity salvaOrganigacao(Organization org) {
        try {
            return ResponseEntity.ok().body(orgRepository.save(org));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    public ResponseEntity findOrgs() {
        try {
            return ResponseEntity.ok().body(orgRepository.findAll());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    public ResponseEntity findOrgById(Integer id) {
        try {
            return ResponseEntity.ok().body(orgRepository.findById(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    public ResponseEntity deleteOrg(Organization org) {
        try {
            orgRepository.delete(org);
            return ResponseEntity.ok().body("Organização deletada com sucesso!");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
