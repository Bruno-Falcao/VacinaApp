package com.example.vacinaapp.services;

import com.example.vacinaapp.models.Profissional;
import com.example.vacinaapp.models.Vacina;
import com.example.vacinaapp.repositories.ProfissionalRepository;
import com.example.vacinaapp.repositories.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepository profissionalRepository;


    public ResponseEntity salvaProfissional(Profissional profissional) {
        try {
            return ResponseEntity.ok().body(profissionalRepository.save(profissional));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    public ResponseEntity buscaTodosProfissionais() {
        try {
            return ResponseEntity.ok().body(profissionalRepository.findAll());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    public ResponseEntity buscaProfissionalPorId(Integer id) {
        try {
            return ResponseEntity.ok().body(profissionalRepository.findById(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    public ResponseEntity deletaProfissional(Profissional profissional) {
        try {
            profissionalRepository.delete(profissional);

            return ResponseEntity.ok().body("Profissional deletado com sucesso");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
