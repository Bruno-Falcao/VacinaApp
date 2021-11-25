package com.example.vacinaapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "professional")
public class Professional {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @JsonProperty("coren_crm")
    private String corenCrm;

    @JsonProperty("birth_date")
    private String birthDate;

}
