package com.skysoft.easyschool.domain;

import com.skysoft.easyschool.utils.UtilsMethods;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
@ToString
@Entity
@Table(name = "stagiaire")
public class Stagiaire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "date_de_naissance")
    private String date_de_naissance;

    @Column(name = "lieu_de_naissance")
    private String lieu_de_naissance;

    @Column(name = "numero")
    private int numero;

    @Column(name = "niveau")
    private String niveau;

    @Column(name = "email")
    private String email;

    @Column(name = "photo")
    private String photo;


    @Column(name = "domaine")
    private String domaine;

    @Column(name = "date_debut")
    private String date_debut;

    @Column(name = "date_de_fin")
    private String date_fin;

    @Column(name = "sexe")
    private String sexe;

    @Column(name = "id_etablissement")
    private Long id_etablisement;

    @Column(name = "id_encadreur")
    private Long id_encadreur;

    @Column(name = "id_projet")
    private Long id_projet;


    @ManyToOne
    private Encadreur encadreur;
/*
    @ManyToOne
    private Secretaire secretaire;*/

    @ManyToOne
    private Etablissement etablissement;

    @ManyToOne
    private User user;

    @ManyToOne
    private Projet projet;

    public Stagiaire() {
        this.nom = nom;
        this.prenom = prenom;
        this.date_de_naissance = date_de_naissance;
        this.lieu_de_naissance = lieu_de_naissance;
        this.numero = numero;
        this.niveau = niveau;
        this.email = email;
        this.photo = photo;
        this.domaine = domaine;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.sexe = sexe;
        this.encadreur = encadreur;
        //this.secretaire = secretaire;
        this.etablissement = etablissement;
        this.user = user;
        this.projet = projet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDate_de_naissance() {
        return date_de_naissance;
    }

    public void setDate_de_naissance(String date_de_naissance) {
        this.date_de_naissance = date_de_naissance;
    }

    public String getLieu_de_naissance() {
        return lieu_de_naissance;
    }

    public void setLieu_de_naissance(String lieu_de_naissance) {
        this.lieu_de_naissance = lieu_de_naissance;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public Encadreur getEncadreur() {
        return encadreur;
    }

    public void setEncadreur(Encadreur encadreur) {
        this.encadreur = encadreur;
    }

    /*public Secretaire getSecretaire() {
        return secretaire;
    }

    public void setSecretaire(Secretaire secretaire) {
        this.secretaire = secretaire;
    }*/

    public Etablissement getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId_etablisement() {
        return id_etablisement;
    }

    public void setId_etablisement(Long id_etablisement) {
        this.id_etablisement = id_etablisement;
    }

    public Long getId_encadreur() {
        return id_encadreur;
    }

    public void setId_encadreur(Long id_encadreur) {
        this.id_encadreur = id_encadreur;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
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

   /* public String getDatedebutText(){
        return getDate_debut() == null ? "-" : UtilsMethods.getDateToString(getDate_debut());
    }
    public String getDatenaissanceText(){
        return getDate_de_naissance() == null ? "-" : UtilsMethods.getDateToStringTwo(getDate_de_naissance());
    }
    public String getDatefinText(){
        return getDate_fin() == null ? "-" : UtilsMethods.getDateToStringThree(getDate_fin());
    }*/
}

    /*@OneToMany(mappedBy = "stagiaire")
    private List<Tache> taches;

    @OneToMany(mappedBy = "stagiaire")
    private List<Rapport> rapports ;*/

