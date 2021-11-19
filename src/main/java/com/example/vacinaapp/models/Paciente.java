package com.example.vacinaapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue
    private Integer id;

    private String nome;

    @JsonProperty("data_nascimento")
    private String dataNascimento;

    private String cpf;
}
