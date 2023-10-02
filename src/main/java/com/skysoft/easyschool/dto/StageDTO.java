/*package com.skysoft.easyschool.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StageDTO {

    @NotBlank
    private String domaine;

    private String nom_etablissement;

    @NotBlank
    @Size(min = 5, max = 50)
    private String theme;

    public String getDomaine() {
        return domaine;
    }

    public String getTheme() {
        return theme;
    }

    public String getNom_etablissement() {
        return nom_etablissement;
    }
}*/
