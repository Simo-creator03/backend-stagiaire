package com.skysoft.easyschool.domain;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "etablissement")
public class Etablissement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_etablissement;

    @Column(name = "nom")
    private String nom;

    @Column(name = "numero")
    private int numero;

    public Etablissement() {
        this.nom = nom;
        this.numero = numero;
    }

    public static Etablissement get() {
        return null;
    }

    public Long getId_etablissement() {
        return id_etablissement;
    }

    public void setId_etablissement(Long id_etablissement) {
        this.id_etablissement = id_etablissement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
