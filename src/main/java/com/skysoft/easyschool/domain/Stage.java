/*
package com.skysoft.easyschool.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "stage")
public class Stage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_stage;

    @Column(name = "domaine")
    private String domaine;

    @Column(name = "date_debut")
    private LocalDate date_debut;

    @Column(name = "date_de_fin")
    private LocalDate date_fin;

    @Column(name = "theme")
    private String theme;


    */
/*@OneToMany(mappedBy = "stage")
    private List<Stagiaire> Stagiaires;*//*

    @ManyToOne
    private Etablissement etablissement;

    public Stage() {
        this.domaine = domaine;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.theme = theme;
        this.etablissement = etablissement;
    }


    public Long getId_stage() {
        return id_stage;
    }

    public void setId_stage(Long id_stage) {
        this.id_stage = id_stage;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public LocalDate getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(LocalDate date_debut) {
        this.date_debut = date_debut;
    }

    public LocalDate getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(LocalDate date_fin) {
        this.date_fin = date_fin;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Etablissement getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }
}
*/
