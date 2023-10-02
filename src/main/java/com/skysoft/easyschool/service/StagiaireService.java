package com.skysoft.easyschool.service;

import com.skysoft.easyschool.domain.Stagiaire;
import com.skysoft.easyschool.dto.StagiaireDTO;
import javassist.NotFoundException;

import java.util.List;

public interface StagiaireService {

    Stagiaire createStagiaire(StagiaireDTO stagiaireDTO) throws NotFoundException;
    Stagiaire updateStagiaire(StagiaireDTO stagiaireDTO) throws NotFoundException;
    void deleteStagiaireById(Long id);
    Stagiaire getStagiaire(Long id) throws NotFoundException;

    List<Stagiaire> getStagiaire(String nom, String prenom, String domaine);

    List<Stagiaire> getAllStagiaire() ;
}
