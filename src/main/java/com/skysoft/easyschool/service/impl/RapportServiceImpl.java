package com.skysoft.easyschool.service.impl;

import com.skysoft.easyschool.domain.Rapport;
import com.skysoft.easyschool.domain.Stagiaire;
import com.skysoft.easyschool.dto.RapportDTO;
import com.skysoft.easyschool.repository.RapportRepository;
import com.skysoft.easyschool.repository.StagiaireRepository;
import com.skysoft.easyschool.repository.specification.RapportSpecification;
import com.skysoft.easyschool.service.RapportService;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class    RapportServiceImpl implements RapportService {

    private final RapportRepository rapportRepository;
    private final StagiaireRepository stagiaireRepository;


    public RapportServiceImpl(RapportRepository rapportRepository, StagiaireRepository stagiaireRepository) {
        this.rapportRepository = rapportRepository;
        this.stagiaireRepository = stagiaireRepository;
    }

    @Override
    public Rapport saveRapport(RapportDTO rapportDTO ) throws NotFoundException {
        Optional<Stagiaire> stagiaire = stagiaireRepository.findById(rapportDTO.getId_stagiaire());
        if(stagiaire.isPresent()) {
            Rapport rapport = new Rapport();
            rapport.setTitre_rapport(rapportDTO.getTitre_rapport());
            rapport.setObjectif_rapport(rapportDTO.getObjectif_rapport());
            rapport.setDate_envoi(rapportDTO.getDate_envoi());
            rapport.setStagiaire(stagiaire.get());
            return rapportRepository.save(rapport);
        }
        else {
            throw new NotFoundException("Le rapport ne peut etre ajouter dans le systeme");
        }
    }

    @Override
    public Rapport updateRapport(RapportDTO rapportDTO) throws NotFoundException {
        Optional<Stagiaire> stagiaire = stagiaireRepository.findById(rapportDTO.getId_stagiaire());
        if(stagiaire.isPresent()) {
            Rapport rapport = getRapport(rapportDTO.getId());
            rapport.setTitre_rapport(rapportDTO.getTitre_rapport());
            rapport.setObjectif_rapport(rapportDTO.getObjectif_rapport());
            rapport.setDate_envoi(rapportDTO.getDate_envoi());
            rapport.setStagiaire(stagiaire.get());
            return rapportRepository.save(rapport);
        }
        else {
            throw new NotFoundException("Le rapport ne peut etre modifier dans le systeme");
        }
    }

    @Override
    public void deleteRapportById(Long id) {
        rapportRepository.deleteById(id);
    }

    @Override
    public List<Rapport> getRapport(String titre_rapport, String date_envoi){
        titre_rapport = ("".equals(titre_rapport) || titre_rapport == null) ? null : titre_rapport;
        date_envoi = ("".equals(date_envoi) || date_envoi == null) ? null : date_envoi;
        return rapportRepository.findAll(RapportSpecification.searchrapport(titre_rapport, date_envoi));
    }

    @Override
    public Rapport getRapport(Long id) {
        return rapportRepository.findById(id).get();
    }

    @Override
    public List<Rapport> getAllRapport() {
        return rapportRepository.findAll();
    }
}
