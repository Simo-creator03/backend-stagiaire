package com.skysoft.easyschool.service;

import com.skysoft.easyschool.domain.Etablissement;
import com.skysoft.easyschool.dto.EtablissementDTO;

import java.util.List;

public interface EtablissementService {

    Etablissement saveEtablissement(EtablissementDTO etablissementDTO);
    Etablissement updateEtablissement(EtablissementDTO etablissementDTO);
    void deleteEtablissementById(Long id);
    Etablissement getEtablissement(Long id_encadreur);

    List<Etablissement> getEtablissement(String nom);

    List<Etablissement> getAllEtablissement();
}
