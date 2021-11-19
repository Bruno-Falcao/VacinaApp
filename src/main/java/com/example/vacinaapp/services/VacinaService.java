package com.example.vacinaapp.services;

import com.example.vacinaapp.models.Vacina;
import com.example.vacinaapp.repositories.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VacinaService {

    @Autowired
    private VacinaRepository vacinaRepository;


    public ResponseEntity salvaVacina(Vacina vacina) {
        try {
            return ResponseEntity.ok().body(vacinaRepository.save(vacina));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    public ResponseEntity buscaTodasVacinas() {
        try {
            return ResponseEntity.ok().body(vacinaRepository.findAll());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    public ResponseEntity buscaVacinaPorId(Integer id) {
        try {
            return ResponseEntity.ok().body(vacinaRepository.findById(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    public ResponseEntity deletaVacina(Vacina vacina) {
        try {
            vacinaRepository.delete(vacina);

            return ResponseEntity.ok().body("Vacina deletada com sucesso");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
