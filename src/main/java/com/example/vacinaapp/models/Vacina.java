package com.example.vacinaapp.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "vacina")
public class Vacina {

    @Id
    @GeneratedValue()
    private Integer id;

    private String nome;

    private String lote;

    private String marca;

    private String fabricacao;
}
