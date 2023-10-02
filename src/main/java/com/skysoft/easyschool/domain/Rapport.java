package com.skysoft.easyschool.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "rapport")
public class Rapport implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titre_rapport")
    private String titre_rapport;

    @Column(name = "objectif")
    private String objectif_rapport;

    @Column(name = "date_envoi")
    private String date_envoi;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Stagiaire", referencedColumnName = "id", nullable = false)
    private Stagiaire stagiaire;

    public Rapport() {
        this.titre_rapport = titre_rapport;
        this.objectif_rapport = objectif_rapport;
        this.date_envoi = date_envoi;
        this.stagiaire = stagiaire;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre_rapport() {
        return titre_rapport;
    }

    public void setTitre_rapport(String titre_rapport) {
        this.titre_rapport = titre_rapport;
    }

    public String getObjectif_rapport() {
        return objectif_rapport;
    }

    public void setObjectif_rapport(String objectif_rapport) {
        this.objectif_rapport = objectif_rapport;
    }

    public String getDate_envoi() {
        return date_envoi;
    }

    public void setDate_envoi(String date_envoi) {
        this.date_envoi = date_envoi;
    }

    public Stagiaire getStagiaire() {
        return stagiaire;
    }

    public void setStagiaire(Stagiaire stagiaire) {
        this.stagiaire = stagiaire;
    }
}
