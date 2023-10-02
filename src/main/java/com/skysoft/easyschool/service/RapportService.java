package com.skysoft.easyschool.service;

import com.skysoft.easyschool.domain.Rapport;
import com.skysoft.easyschool.dto.RapportDTO;
import javassist.NotFoundException;

import java.util.List;

public interface RapportService {

    Rapport saveRapport(RapportDTO rapportDTO) throws NotFoundException;
    Rapport updateRapport(RapportDTO rapportDTO) throws NotFoundException;
    void deleteRapportById(Long id);

    List<Rapport> getRapport(String titre_rapport, String date_envoi);

    Rapport getRapport(Long id);
    List<Rapport> getAllRapport();
}
