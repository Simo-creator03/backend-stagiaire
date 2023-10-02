package com.skysoft.easyschool.service;

import com.skysoft.easyschool.domain.Encadreur;
import com.skysoft.easyschool.dto.EncadreurDTO;

import java.util.List;

public interface EncadreurService {

    Encadreur saveEncadreur(EncadreurDTO encadreurDTO);
    Encadreur updateEncadreur(EncadreurDTO encadreurDTO);
    void deleteEncadreurById(Long id);
    Encadreur getEncadreur(Long id_encadreur);
    List<Encadreur> getAllEncadreur();

    List<Encadreur> getEncadreur(String nom, String prenom_encadreur);
}
