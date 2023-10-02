package com.skysoft.easyschool.service.impl;

import com.skysoft.easyschool.domain.Encadreur;
import com.skysoft.easyschool.domain.User;
import com.skysoft.easyschool.dto.EncadreurDTO;
import com.skysoft.easyschool.repository.EncadreurRepository;
import com.skysoft.easyschool.repository.UserRepository;
import com.skysoft.easyschool.repository.specification.EncadreurSpecification;
import com.skysoft.easyschool.service.EncadreurService;
import com.skysoft.easyschool.utils.SecurityUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EncadreurServiceImpl implements EncadreurService {


    private final EncadreurRepository encadreurRepository;
    private final UserRepository userRepository;

    public EncadreurServiceImpl(EncadreurRepository encadreurRepository, UserRepository userRepository) {
        this.encadreurRepository = encadreurRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Encadreur saveEncadreur(EncadreurDTO encadreurDTO) {
        Optional<User> user = userRepository.findByLogin(SecurityUtils.getCurrentUserLogin().toString());
        Encadreur encadreur = new Encadreur();
        encadreur.setNom(encadreurDTO.getnom());
        encadreur.setPrenom_encadreur(encadreurDTO.getPrenom());
        encadreur.setNumero(encadreurDTO.getNumero());
        encadreur.setUser(user.orElse(null));
        return  encadreurRepository.save(encadreur);
    }

    @Override
    public Encadreur updateEncadreur(EncadreurDTO encadreurDTO) {
        Encadreur encadreur = getEncadreur(encadreurDTO.getId());
        encadreur.setNom(encadreurDTO.getnom());
        encadreur.setPrenom_encadreur(encadreurDTO.getPrenom());
        encadreur.setNumero(encadreurDTO.getNumero());
        return  encadreurRepository.save(encadreur);
    }


    @Override
    public void deleteEncadreurById(Long id_encadreur) {
        encadreurRepository.deleteById(id_encadreur);

    }

    @Override
    public Encadreur getEncadreur(Long id_encadreur) {
        return encadreurRepository.findById(id_encadreur).get();
    }

    @Override
    public List<Encadreur> getAllEncadreur() {
        return encadreurRepository.findAll();
    }

    @Override
    public List<Encadreur> getEncadreur(String nom, String prenom_encadreur){
        nom = ("".equals(nom) || nom == null) ? null : nom;
        prenom_encadreur = ("".equals(prenom_encadreur) || prenom_encadreur == null) ? null : prenom_encadreur;
        return encadreurRepository.findAll(EncadreurSpecification.searchencadreur(nom, prenom_encadreur));
    }
}
