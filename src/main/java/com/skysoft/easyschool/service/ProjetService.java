package com.skysoft.easyschool.service;

import com.skysoft.easyschool.domain.Projet;
import com.skysoft.easyschool.dto.ProjetDTO;
import javassist.NotFoundException;

import java.util.List;

public interface ProjetService {

    Projet saveProjet(ProjetDTO projetDTO) throws NotFoundException;
    Projet updateProjet(ProjetDTO projetDTO) throws NotFoundException;
    void deleteProjetById(Long id);

    List<Projet> getProjet(String nom_projet, String date_creation);

    Projet getProjet(Long id);
    List<Projet> getAllProjet();
}
