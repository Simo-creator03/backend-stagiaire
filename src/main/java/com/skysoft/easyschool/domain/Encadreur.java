package com.skysoft.easyschool.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "encadreur")
public class Encadreur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_encadreur;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom_encadreur;

    @Column(name = "numero")
    private int numero;

    @ManyToOne
    private User user;

    public Encadreur() {
        this.nom = nom;
        this.prenom_encadreur = prenom_encadreur;
        this.numero = numero;
        this.user = user;
    }

    public Long getId_encadreur() {
        return id_encadreur;
    }

    public void setId_encadreur(Long id_encadreur) {
        this.id_encadreur = id_encadreur;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
