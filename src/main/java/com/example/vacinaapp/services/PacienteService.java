package com.example.vacinaapp.services;

import com.example.vacinaapp.models.Paciente;
import com.example.vacinaapp.models.Vacina;
import com.example.vacinaapp.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public ResponseEntity salvaPaciente(Paciente paciente) {
        try {
            return ResponseEntity.ok().body(pacienteRepository.save(paciente));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    public ResponseEntity buscaTodosPacientes() {
        try {
            return ResponseEntity.ok().body(pacienteRepository.findAll());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    public ResponseEntity buscaPacientesPorId(Integer id) {
        try {
            return ResponseEntity.ok().body(pacienteRepository.findById(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    public ResponseEntity deletaPaciente(Paciente paciente) {
        try {
            pacienteRepository.delete(paciente);

            return ResponseEntity.ok().body("Paciente deletado com sucesso");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
