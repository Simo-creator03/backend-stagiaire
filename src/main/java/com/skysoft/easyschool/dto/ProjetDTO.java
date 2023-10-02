package com.skysoft.easyschool.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjetDTO {

    private Long id;
    @NotBlank
    private String nom_projet;

    private String date_creation;

    public Long getId() {
        return id;
    }

    public String getNom_projet() {
        return nom_projet;
    }

    public String getDate_creation() {
        return date_creation;
    }
}
