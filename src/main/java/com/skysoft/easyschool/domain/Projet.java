package com.skysoft.easyschool.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "projet")
public class Projet  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom_projet")
    private String nom_projet;

    @Column(name = "date_creation")
    private String date_creation;

    @ManyToOne
    private User user;

    public Projet() {
        this.nom_projet = nom_projet;
        this.date_creation = date_creation;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom_projet() {
        return nom_projet;
    }

    public void setNom_projet(String nom_projet) {
        this.nom_projet = nom_projet;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
