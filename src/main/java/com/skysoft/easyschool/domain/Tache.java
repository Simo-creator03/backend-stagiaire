package com.skysoft.easyschool.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tache")
public class Tache implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tache;

    @Column(name = "objectif_tache")
    private String objectif_tache;

    @Column(name = "statut")
    private String statut;

    @Column(name = "date_de_debut_tache")
    private String date_debut_tache;

    @Column(name = "date_de_fin_tache")
    private String date_fin_tache;

    @Column(name = "id_stagiaire")
    private Long id_stagiaire;

    @Column(name = "id_projet")
    private Long id_projet;

    @ManyToOne
    private Stagiaire stagiaire;

    @ManyToOne
    private Projet projet;

    public Tache() {
        this.objectif_tache = objectif_tache;
        this.statut = statut;
        this.date_debut_tache = date_debut_tache;
        this.date_fin_tache = date_fin_tache;
        this.stagiaire = stagiaire;
        this.projet = projet;
    }


    /*public Long getId_tache() {
        return Id_tache;
    }

    public void setId_tache(Long id_tache) {
        Id_tache = id_tache;
    }*/

    public String getObjectif_tache() {
        return objectif_tache;
    }

    public void setObjectif_tache(String objectif_tache) {
        this.objectif_tache = objectif_tache;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getDate_debut_tache() {
        return date_debut_tache;
    }

    public void setDate_debut_tache(String date_debut_tache) {
        this.date_debut_tache = date_debut_tache;
    }


    public Stagiaire getStagiaire() {
        return stagiaire;
    }

    public void setStagiaire(Stagiaire stagiaire) {
        this.stagiaire = stagiaire;
    }

    public String getDate_fin_tache() {
        return date_fin_tache;
    }

    public void setDate_fin_tache(String date_fin_tache) {
        this.date_fin_tache = date_fin_tache;
    }

    public Long getId_stagiaire() {
        return id_stagiaire;
    }

    public void setId_stagiaire(Long id_stagiaire) {
        this.id_stagiaire = id_stagiaire;
    }

    public Long getId_tache() {
        return id_tache;
    }

    public void setId_tache(Long id_tache) {
        this.id_tache = id_tache;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public Long getId_projet() {
        return id_projet;
    }

    public void setId_projet(Long id_projet) {
        this.id_projet = id_projet;
    }
}
