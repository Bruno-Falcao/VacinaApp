package com.example.vacinaapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "organization")
public class Organization {

    @Id
    @GeneratedValue
    private Integer id;

    private String cnpj;

    @JsonProperty("fantasy-name")
    private String fantasyName;

    private String identification;
}
