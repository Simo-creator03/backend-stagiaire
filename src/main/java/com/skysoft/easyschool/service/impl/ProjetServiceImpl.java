package com.skysoft.easyschool.service.impl;

import com.skysoft.easyschool.domain.Projet;
import com.skysoft.easyschool.domain.User;
import com.skysoft.easyschool.dto.ProjetDTO;
import com.skysoft.easyschool.repository.ProjetRepository;
import com.skysoft.easyschool.repository.UserRepository;
import com.skysoft.easyschool.repository.specification.ProjetSpecification;
import com.skysoft.easyschool.service.ProjetService;

import com.skysoft.easyschool.utils.SecurityUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetServiceImpl implements ProjetService {

    private final ProjetRepository projetRepository;
    private final UserRepository userRepository;

    public ProjetServiceImpl(ProjetRepository projetRepository, UserRepository userRepository) {
        this.projetRepository = projetRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Projet saveProjet(ProjetDTO projetDTO) {
        Optional<User> user = userRepository.findByLogin(SecurityUtils.getCurrentUserLogin().toString());
        Projet projet = new Projet();
        projet.setNom_projet(projetDTO.getNom_projet());
        projet.setDate_creation(projetDTO.getDate_creation());
        projet.setUser(user.orElse(null));
        return  projetRepository.save(projet);
    }

    @Override
    public Projet updateProjet(ProjetDTO projetDTO) {
        Projet projet = getProjet(projetDTO.getId());
        projet.setNom_projet(projetDTO.getNom_projet());
        projet.setDate_creation(projetDTO.getDate_creation());
        return  projetRepository.save(projet);
    }

    @Override
    public void deleteProjetById(Long id) {
        projetRepository.deleteById(id);
    }

    @Override
    public Projet getProjet(Long id) {
        return projetRepository.findById(id).get();
    }

    @Override
    public List<Projet> getAllProjet() {
        return projetRepository.findAll();
    }

    @Override
    public List<Projet> getProjet(String nom_projet, String date_creation){
        nom_projet = ("".equals(nom_projet) || nom_projet == null) ? null : nom_projet;
        date_creation = ("".equals(date_creation) || date_creation == null) ? null : date_creation;
        return projetRepository.findAll(ProjetSpecification.searchprojet(nom_projet, date_creation));
    }

}
