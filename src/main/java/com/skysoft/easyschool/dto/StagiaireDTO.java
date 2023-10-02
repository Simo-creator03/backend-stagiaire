package com.skysoft.easyschool.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.lang.String;
import java.time.LocalDateTime;

public class StagiaireDTO {


    private Long id;

    private String nom;

    private String prenom;

    private String date_de_naissance;

    private String lieu_de_naissance;

    private int numero;

    private String niveau;

    private String email;

    private String photo;

    private Long id_projet;

    @NotBlank
    private String domaine;

    private String date_debut;

    private String date_fin;


    private String sexe;

    private Long id_etablissement;

    private Long id_encadreur;

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDate_de_naissance() {
        return date_de_naissance;
    }

    public String getLieu_de_naissance() {
        return lieu_de_naissance;
    }

    public int getNumero() {
        return numero;
    }

    public String getNiveau() {
        return niveau;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoto() {
        return photo;
    }

    public String getDomaine() {
        return domaine;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public Long getId() {
        return id;
    }

    public Long getId_etablissement() {
        return id_etablissement;
    }

    public Long getId_encadreur() {
        return id_encadreur;
    }

    public String getSexe() {
        return sexe;
    }

    public Long getId_projet() {
        return id_projet;
    }
}
