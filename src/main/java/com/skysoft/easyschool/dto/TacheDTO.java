package com.skysoft.easyschool.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TacheDTO {

    private Long id;

    @NotBlank
    private String objectif_tache;

    @NotBlank
    private String statut;

    private String date_debut_tache;

    private String Date_fin_tache;

    private String nom_stagiaire;

    private Long id_stagiaire;

    private Long id_projet;

    public String getObjectif_tache() {
        return objectif_tache;
    }

    public String getStatut() {
        return statut;
    }

    public String getDate_debut_tache() {
        return date_debut_tache;
    }

    public String getDate_fin_tache() {
        return Date_fin_tache;
    }

    public String getNom_stagiaire() {
        return nom_stagiaire;
    }

    public Long getId() {
        return id;
    }

    public Long getId_stagiaire() {
        return id_stagiaire;
    }

    public Long getId_projet() {
        return id_projet;
    }
}
