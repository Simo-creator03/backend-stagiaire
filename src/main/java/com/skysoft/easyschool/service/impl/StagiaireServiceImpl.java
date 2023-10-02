package com.skysoft.easyschool.service.impl;

import com.skysoft.easyschool.domain.*;
import com.skysoft.easyschool.dto.StagiaireDTO;
import com.skysoft.easyschool.dto.UserDTO;
import com.skysoft.easyschool.repository.*;
import com.skysoft.easyschool.repository.specification.StagiaireSpecification;
import com.skysoft.easyschool.service.StagiaireService;
import com.skysoft.easyschool.service.UserService;
import com.skysoft.easyschool.utils.SecurityUtils;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StagiaireServiceImpl implements StagiaireService {

    private final StagiaireRepository stagiaireRepository;
    private final UserRepository userRepository;
    private final EncadreurRepository encadreurRepository;
    private final SecretaireRepository secretaireRepository;
    private final EtablissementRepository etablissementRepository;
    private Object Stagiaire;
    private final UserService userService;
    private final ProjetRepository projetRepository;

    public StagiaireServiceImpl(StagiaireRepository stagiaireRepository, UserRepository userRepository, EncadreurRepository encadreurRepository, SecretaireRepository secretaireRepository, EtablissementRepository etablissementRepository, UserService userService, ProjetRepository projetRepository) {
        this.stagiaireRepository = stagiaireRepository;
        this.userRepository = userRepository;
        this.encadreurRepository = encadreurRepository;
        this.secretaireRepository = secretaireRepository;
        this.etablissementRepository = etablissementRepository;
        this.userService = userService;
        this.projetRepository = projetRepository;
    }


    @Override
    public Stagiaire createStagiaire (StagiaireDTO stagiaireDTO) throws NotFoundException {
        Optional<User> user = userRepository.findByLogin(SecurityUtils.getCurrentUserLogin().get());
        Optional<Encadreur> encadreur = encadreurRepository.findById(stagiaireDTO.getId_encadreur());
        /*Optional<Secretaire> secretaire = secretaireRepository.findByNom(stagiaireDTO.getNom());*/
        Optional<Etablissement> etablissement = etablissementRepository.findById(stagiaireDTO.getId_etablissement());
        Optional<Projet> projet = projetRepository.findById(stagiaireDTO.getId_projet());
        System.out.println(etablissement.get().getNom() + "\n");
        System.out.println(encadreur.get().getNom()+ "\n");
        System.out.println(projet.get().getNom_projet()+ "\n");
        System.out.println(user.get().getLogin());

        if(user.isPresent()&& encadreur.isPresent() && etablissement.isPresent()&& projet.isPresent()) {
            System.out.println("Donnée existante");

            Stagiaire stagiaire = new Stagiaire();
            stagiaire.setNom(stagiaireDTO.getNom());
            stagiaire.setPrenom(stagiaireDTO.getPrenom());
            stagiaire.setDate_de_naissance(stagiaireDTO.getDate_de_naissance());
            stagiaire.setLieu_de_naissance(stagiaireDTO.getLieu_de_naissance());
            stagiaire.setNumero(stagiaireDTO.getNumero());
            stagiaire.setNiveau(stagiaireDTO.getNiveau());
            stagiaire.setEmail(stagiaireDTO.getEmail());
            stagiaire.setPhoto(stagiaireDTO.getPhoto());
            stagiaire.setDomaine(stagiaireDTO.getDomaine());
            stagiaire.setDate_debut(stagiaireDTO.getDate_debut());
            stagiaire.setDate_fin(stagiaireDTO.getDate_fin());
            stagiaire.setSexe(stagiaireDTO.getSexe());
            stagiaire.setId_etablisement(stagiaireDTO.getId_etablissement());
            stagiaire.setId_encadreur(stagiaireDTO.getId_encadreur());
            stagiaire.setId_projet(stagiaireDTO.getId_projet());
            stagiaire.setUser(user.get());
            stagiaire.setEncadreur(encadreur.get());
            /*stagiaire.setSecretaire(secretaire.get());*/
            stagiaire.setProjet(projet.get());
            stagiaire.setEtablissement(etablissement.get());
            stagiaire.setUser(user.orElse(null));
            System.out.println(stagiaire);


            /*UserDTO userDTO = new UserDTO();
            userDTO.setLogin(stagiaireDTO.getNom());
            userDTO.setEmail(stagiaireDTO.getEmail());
            userDTO.setTelephone(String.valueOf(stagiaireDTO.getNumero()));
            userDTO.setPassword("1234");
            Set<String> roles = new HashSet<String>();
            roles.add("ROLE_USER");
            userDTO.setAuthorities(roles);
            userService.createUser(userDTO);*/

            return stagiaireRepository.save(stagiaire);
                    }
        else {
            throw new NotFoundException("Le stagiaire ne peut etre ajouté dans le systeme");
        }
    }

    @Override
    public Stagiaire updateStagiaire (StagiaireDTO stagiaireDTO) throws NotFoundException {
        Optional<User> user = userRepository.findByLogin(SecurityUtils.getCurrentUserLogin().get());
        Optional<Encadreur> encadreur = encadreurRepository.findById(stagiaireDTO.getId_encadreur());
        /*Optional<Secretaire> secretaire = secretaireRepository.findByNom(stagiaireDTO.getNom());*/
        Optional<Etablissement> etablissement = etablissementRepository.findById(stagiaireDTO.getId_etablissement());
        Optional<Projet> projet = projetRepository.findById(stagiaireDTO.getId_projet());
        System.out.println(etablissement.get().getNom() + "\n");
        System.out.println(encadreur.get().getNom()+ "\n");
        System.out.println(user.get().getLogin());

        if(user.isPresent()&& encadreur.isPresent() && etablissement.isPresent()&& projet.isPresent()) {
            System.out.println("Donnée exisstante");
            Stagiaire stagiaire = getStagiaire(stagiaireDTO.getId());
            System.out.println(stagiaireDTO.getId());
            if (stagiaire != null){
            stagiaire.setNom(stagiaireDTO.getNom());
            stagiaire.setPrenom(stagiaireDTO.getPrenom());
            stagiaire.setDate_de_naissance(stagiaireDTO.getDate_de_naissance());
            stagiaire.setLieu_de_naissance(stagiaireDTO.getLieu_de_naissance());
            stagiaire.setNumero(stagiaireDTO.getNumero());
            stagiaire.setNiveau(stagiaireDTO.getNiveau());
            stagiaire.setEmail(stagiaireDTO.getEmail());
            stagiaire.setPhoto(stagiaireDTO.getPhoto());
            stagiaire.setDomaine(stagiaireDTO.getDomaine());
            stagiaire.setDate_debut(stagiaireDTO.getDate_debut());
            stagiaire.setDate_fin(stagiaireDTO.getDate_fin());
            stagiaire.setSexe(stagiaireDTO.getSexe());
            stagiaire.setId_etablisement(stagiaireDTO.getId_etablissement());
            stagiaire.setId_encadreur(stagiaireDTO.getId_encadreur());
            stagiaire.setId_projet(stagiaireDTO.getId_projet());
            stagiaire.setUser(user.get());
            stagiaire.setEncadreur(encadreur.get());
            /*stagiaire.setSecretaire(secretaire.get());*/
                stagiaire.setProjet(projet.get());
            stagiaire.setEtablissement(etablissement.get());
            stagiaire.setUser(user.orElse(null));

            System.out.println(stagiaire.toString());
            return stagiaireRepository.save(stagiaire);
            }
            else {
                System.out.println("aucun");
            }
            return null;
        }
        else {
            throw new NotFoundException("Le stagiaire ne peut etre modifier dans le systeme");
        }
    }

    @Override
    public void deleteStagiaireById(Long id ) {
            stagiaireRepository.deleteById(id);
        }

    @Override
    public Stagiaire getStagiaire(Long id) {
        return stagiaireRepository.findById(id).get();
    }

    @Override
    public List<Stagiaire> getStagiaire(String nom, String prenom, String domaine){
        nom = ("".equals(nom) || nom == null) ? null : nom;
        prenom = ("".equals(prenom) || prenom == null) ? null : prenom;
        domaine = ("".equals(domaine) || domaine == null) ? null : domaine;
        return stagiaireRepository.findAll(StagiaireSpecification.searchstagiaire(nom, prenom, domaine));
    }

    @Override
    public List<Stagiaire> getAllStagiaire() {
        return stagiaireRepository.findAll();
    }
}
