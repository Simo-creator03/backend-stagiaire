package com.skysoft.easyschool.service.impl;

import com.skysoft.easyschool.domain.Etablissement;
import com.skysoft.easyschool.dto.EtablissementDTO;
import com.skysoft.easyschool.repository.EtablissementRepository;
import com.skysoft.easyschool.repository.specification.EtablissementSpecification;
import com.skysoft.easyschool.service.EtablissementService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtablissementServiceImpl implements EtablissementService {

    private final EtablissementRepository etablissementRepository;

    public EtablissementServiceImpl(EtablissementRepository etablissementRepository) {
        this.etablissementRepository = etablissementRepository;
    }

    @Override
    public Etablissement saveEtablissement(EtablissementDTO etablissementDTO) {
        Etablissement etablissement = new Etablissement();
        etablissement.setNom(etablissementDTO.getNom_etablissement());
        etablissement.setNumero(etablissementDTO.getNumero());
        return  etablissementRepository.save(etablissement);
    }

    @Override
    public Etablissement updateEtablissement(EtablissementDTO etablissementDTO) {
        System.out.println("\n\n\n\n"+etablissementDTO.getId()+ "\n\n\n");
        Etablissement etablissement = getEtablissement(etablissementDTO.getId());
        etablissement.setNom(etablissementDTO.getNom_etablissement());
        etablissement.setNumero(etablissementDTO.getNumero());
        return  etablissementRepository.save(etablissement);
    }

    @Override
    public void deleteEtablissementById(Long id) {
        System.out.println("\n\n\n\n" +id+ "\n\n\n");
        etablissementRepository.deleteById(id);

    }

    @Override
    public Etablissement getEtablissement(Long id_etablissement) {
        return etablissementRepository.findById(id_etablissement).orElse(null);
    }

    @Override
    public List<Etablissement> getEtablissement(String nom){
        return etablissementRepository.findAll(EtablissementSpecification.searchetablissement(nom));
    }

    @Override
    public List<Etablissement> getAllEtablissement() {
        return etablissementRepository.findAll();
    }
}
