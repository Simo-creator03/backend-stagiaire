package com.skysoft.easyschool.service;

import com.skysoft.easyschool.domain.Tache;
import com.skysoft.easyschool.dto.TacheDTO;
import javassist.NotFoundException;

import java.util.List;

public interface TacheService {

    Tache saveTache(TacheDTO tacheDTO) throws NotFoundException;
    Tache updateTache(TacheDTO tacheDTO)  throws NotFoundException;
    void deleteTacheById(Long id);

    List<Tache> getTache(String objectif_tache, String statut);

    Tache getTache(Long id_tache);

    List<Tache> getAllTache();

}
