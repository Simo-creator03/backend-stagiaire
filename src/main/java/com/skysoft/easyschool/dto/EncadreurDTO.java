package com.skysoft.easyschool.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EncadreurDTO {

    private Long id;

    @NotBlank
    private String nom;

    @Size(min = 3, max = 10)
    private String prenom;

    @Size(min = 8, max = 13)
    private int numero;


    public String getnom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getNumero() {
        return numero;
    }

    public Long getId() {
        return id;
    }
}
