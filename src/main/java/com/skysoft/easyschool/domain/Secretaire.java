package com.skysoft.easyschool.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "secretaire")
public class Secretaire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_secretaire;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom_encadreur;

    /*@OneToMany(mappedBy = "secretaire")
    private List<Stagiaire> Stagiaires;*/

    @ManyToOne
    private User user;

    public Secretaire(String nom, String prenom_encadreur, List<Stagiaire> stagiaires, User user) {
        this.nom = nom;
        this.prenom_encadreur = prenom_encadreur;
        /*Stagiaires = stagiaires;*/
        this.user = user;
    }

    public Long getId_secretaire() {
        return id_secretaire;
    }

    public void setId_secretaire(Long id_secretaire) {
        this.id_secretaire = id_secretaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom_encadreur() {
        return prenom_encadreur;
    }

    public void setPrenom_encadreur(String prenom_encadreur) {
        this.prenom_encadreur = prenom_encadreur;
    }

   /* public List<Stagiaire> getStagiaires() {
        return Stagiaires;
    }

    public void setStagiaires(List<Stagiaire> stagiaires) {
        Stagiaires = stagiaires;
    }*/

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
