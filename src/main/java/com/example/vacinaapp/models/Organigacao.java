package com.example.vacinaapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "organigacao")
public class Organigacao {

    @Id
    @GeneratedValue
    private String id;

    private String cnpj;

    @JsonProperty(namespace = "nome_fantasia")
    private String nomeFantasia;

    private String identificacao;
}
