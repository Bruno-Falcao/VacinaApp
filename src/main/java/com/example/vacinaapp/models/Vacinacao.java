package com.example.vacinaapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "vacinacao")
public class Vacinacao {

    @Id
    @GeneratedValue
    private String id;

    private String vacinacao;

    @JsonProperty("proxima_vacinacao")
    private String proximaVacinacao;

    @JsonProperty("id_vacina")
    private String idVacina;

    @JsonProperty("id_profissional")
    private String idProfissional;

    @JsonProperty("id_paciente")
    private String idPaciente;
}
