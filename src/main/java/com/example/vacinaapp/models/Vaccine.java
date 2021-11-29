package com.example.vacinaapp.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "vaccine")
public class Vaccine {

    @Id
    @GeneratedValue()
    private Integer id;

    private String nome;

    private String batch;

    private String brand;

    private String fabrication;
}
