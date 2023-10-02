package com.skysoft.easyschool.service.impl;

import com.skysoft.easyschool.domain.Projet;
import com.skysoft.easyschool.domain.Stagiaire;
import com.skysoft.easyschool.domain.Tache;
import com.skysoft.easyschool.dto.TacheDTO;
import com.skysoft.easyschool.repository.ProjetRepository;
import com.skysoft.easyschool.repository.StagiaireRepository;
import com.skysoft.easyschool.repository.TacheRepository;
import com.skysoft.easyschool.repository.specification.TacheSpecification;
import com.skysoft.easyschool.service.TacheService;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TacheServiceImpl implements TacheService {

    private final TacheRepository tacheRepository;
    private final StagiaireRepository stagiaireRepository;
    private final ProjetRepository projetRepository;

    public TacheServiceImpl(TacheRepository tacheRepository, StagiaireRepository stagiaireRepository, ProjetRepository projetRepository) {
        this.tacheRepository = tacheRepository;
        this.stagiaireRepository = stagiaireRepository;
        this.projetRepository = projetRepository;
    }

    @Override
    public Tache saveTache(TacheDTO tacheDTO ) throws NotFoundException {
        Optional<Stagiaire> stagiaire = stagiaireRepository.findById(tacheDTO.getId_stagiaire());
        Optional<Projet> projet = projetRepository.findById(tacheDTO.getId_projet());
        System.out.println(stagiaire.get().getNom()+ "\n");
        if(stagiaire.isPresent()&& projet.isPresent()) {
            System.out.println("Donnée exisstante");
            Tache tache = new Tache();
            tache.setObjectif_tache(tacheDTO.getObjectif_tache());
            tache.setDate_debut_tache(tacheDTO.getDate_debut_tache());
            tache.setDate_fin_tache(tacheDTO.getDate_fin_tache());
            tache.setStatut(tacheDTO.getStatut());
            tache.setStagiaire(stagiaire.get());
            tache.setProjet(projet.get());
            return tacheRepository.save(tache);
        }
        else {
            throw new NotFoundException("Le tache ne peut etre ajouter dans le systeme");
        }
    }

    @Override
    public Tache updateTache(TacheDTO tacheDTO ) throws NotFoundException {
        Optional<Stagiaire> stagiaire = stagiaireRepository.findById(tacheDTO.getId_stagiaire());
        Optional<Projet> projet = projetRepository.findById(tacheDTO.getId_projet());
        if(stagiaire.isPresent()&& projet.isPresent()) {
            System.out.println("Donnée exisstante");
            Tache tache = getTache(tacheDTO.getId());
            tache.setObjectif_tache(tacheDTO.getObjectif_tache());
            tache.setDate_debut_tache(tacheDTO.getDate_debut_tache());
            tache.setDate_fin_tache(tacheDTO.getDate_fin_tache());
            tache.setStatut(tacheDTO.getStatut());
            tache.setStagiaire(stagiaire.get());
            tache.setProjet(projet.get());
            return tacheRepository.save(tache);
        }
        else {
            throw new NotFoundException("Le rapport ne peut etre modifier dans le systeme");
        }
    }

    @Override
    public void deleteTacheById(Long id) {
        tacheRepository.deleteById(id);
    }

    @Override
    public List<Tache> getTache(String objectif_tache, String statut){
        objectif_tache = ("".equals(objectif_tache) || objectif_tache == null) ? null : objectif_tache;
        statut = ("".equals(statut) || statut == null) ? null : statut;
        return tacheRepository.findAll(TacheSpecification.searchtache(objectif_tache, statut));
    }

    @Override
    public Tache getTache(Long id_tache) {
        return tacheRepository.findById(id_tache).get();
    }

    @Override
    public List<Tache> getAllTache() {
        return tacheRepository.findAll();
    }

}
