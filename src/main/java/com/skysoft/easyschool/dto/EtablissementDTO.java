package com.skysoft.easyschool.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtablissementDTO {

    private Long id;
    @NotBlank
    @Size(min = 5, max = 25)
    private String nom_etablissement;

    private int numero;

    public String getNom_etablissement() {
        return nom_etablissement;
    }

    public int getNumero() {
        return numero;
    }

    public Long getId() {
        return id;
    }
}
