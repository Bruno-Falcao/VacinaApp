package com.example.vacinaapp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class EmailDto {

    @NotBlank
    @JsonProperty("owner_ref")
    private String ownerRef;

    @NotBlank
    @Email
    @JsonProperty("email_from")
    private String emailFrom;

    @NotBlank
    @JsonProperty("email_to")
    private String emailTo;

    @NotBlank
    private String subject;

    @NotBlank
    private String text;
}
