package com.example.vacinaapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "profissional")
public class Profissional {

    @Id
    @GeneratedValue
    private String id;

    private String nome;

    @JsonProperty("coren_Crm")
    private String corenCrm;

    @JsonProperty("data_nascimento")
    private String dataNascimento;
}