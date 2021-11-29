package com.example.vacinaapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "vaccination")
public class Vaccination {

    @Id
    @GeneratedValue
    private Integer id;

    @JsonProperty("vaccination_date")
    private String vaccinationDate;

    @JsonProperty("next_vaccination")
    private String nextVaccination;

    @JsonProperty("vaccine_id")
    private Integer vaccineId;

    @JsonProperty("professional_id")
    private Integer professionalId;

    @JsonProperty("patient_id")
    private Integer patientId;
}
