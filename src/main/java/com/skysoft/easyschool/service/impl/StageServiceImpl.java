/*
package com.skysoft.easyschool.service.impl;

import com.skysoft.easyschool.domain.Etablissement;
import com.skysoft.easyschool.domain.Stage;
import com.skysoft.easyschool.dto.StageDTO;
import com.skysoft.easyschool.repository.EtablissementRepository;
import com.skysoft.easyschool.repository.StageRepository;
import com.skysoft.easyschool.service.StageService;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StageServiceImpl implements StageService {

    private final StageRepository stageRepository;
    private final EtablissementRepository etablissementRepository;

    public StageServiceImpl(StageRepository stageRepository, EtablissementRepository etablissementRepository) {
        this.stageRepository = stageRepository;
        this.etablissementRepository = etablissementRepository;
    }

    @Override
    public Stage saveStage(StageDTO stageDTO) throws NotFoundException {
        Optional<Etablissement> etablissement = etablissementRepository.findByNom(stageDTO.getNom_etablissement());
        if(etablissement.isPresent()) {
            Stage stage = new Stage();
            stage.setEtablissement(etablissement.get());
            return stageRepository.save(stage);
        }
        else {
            throw new NotFoundException("Le rapport ne peut etre ajouter dans le systeme");
        }
    }

    @Override
    public Stage updateStage(StageDTO stageDTO) throws NotFoundException {
        Optional<Etablissement> etablissement = etablissementRepository.findByNom(stageDTO.getNom_etablissement());
        if(etablissement.isPresent()) {
            Stage stage = new Stage();
            stage.setEtablissement(etablissement.get());
            return stageRepository.save(stage);
        }
        else {
            throw new NotFoundException("Le rapport ne peut etre modifier dans le systeme");
        }
    }

    @Override
    public void deleteStageById(Long id_stage) {
        stageRepository.deleteById(id_stage);

    }

    @Override
    public Stage getStage(Long id_stage) {
        return stageRepository.findById(id_stage).get();
    }

    @Override
    public List<Stage> getAllStage() {
        return stageRepository.findAll();
    }

}
*/
