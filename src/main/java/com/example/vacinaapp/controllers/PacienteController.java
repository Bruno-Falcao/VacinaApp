package com.example.vacinaapp.controllers;

import com.example.vacinaapp.models.Organigacao;
import com.example.vacinaapp.models.Paciente;
import com.example.vacinaapp.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/cadastrar")
    public ResponseEntity cadastraPaciente(@RequestBody Paciente paciente) {
        try {
            return pacienteService.salvaPaciente(paciente);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping("/cadastrar")
    public ResponseEntity alterarOrg(@RequestBody Paciente paciente) {
        try {
            return pacienteService.salvaPaciente(paciente);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/busca-paciente")
    public ResponseEntity buscaPacientes(@RequestParam(required = false) Integer id) {
        try {
            if (id != null) {
                return pacienteService.buscaPacientesPorId(id);
            }
            return pacienteService.buscaTodosPacientes();

        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/deleta-paciente")
    public ResponseEntity deletaOrg(@RequestBody Paciente paciente) {
        try {
            return pacienteService.deletaPaciente(paciente);

        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
