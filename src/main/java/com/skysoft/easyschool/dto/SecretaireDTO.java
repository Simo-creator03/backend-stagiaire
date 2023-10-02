package com.skysoft.easyschool.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecretaireDTO {

    private Long id;

    @NotBlank
    private String nom_secretaire;

    public String getNom_secretaire() {
        return nom_secretaire;
    }

    public Long getId() {
        return id;
    }
}
