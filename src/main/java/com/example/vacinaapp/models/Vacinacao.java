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
    private Integer id;

    @JsonProperty("vacinacao_data")
    private String vacinacaoData;

    @JsonProperty("proxima_vacinacao")
    private String proximaVacinacao;

    @JsonProperty("id_vacina")
    private Integer idVacina;

    @JsonProperty("id_profissional")
    private Integer idProfissional;

    @JsonProperty("id_paciente")
    private Integer idPaciente;
}
