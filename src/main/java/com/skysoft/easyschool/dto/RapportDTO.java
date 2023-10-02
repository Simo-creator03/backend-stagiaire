package com.skysoft.easyschool.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RapportDTO {

    private Long id;
    @NotBlank
    private String titre_rapport;

    private String objectif_rapport;

    private String date_envoi;

    private Long id_stagiaire;

    public String getTitre_rapport() {
        return titre_rapport;
    }

    public String getObjectif_rapport() {
        return objectif_rapport;
    }

    public String getDate_envoi() {
        return date_envoi;
    }

    public Long getId() {
        return id;
    }

    public Long getId_stagiaire() {
        return id_stagiaire;
    }
}
