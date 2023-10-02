package com.skysoft.easyschool.repository;

import com.skysoft.easyschool.domain.Encadreur;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface EncadreurRepository extends JpaRepository<Encadreur, Long> {

    Optional<Encadreur> findByNom(String nom);

    List<Encadreur> findAll(Specification<Encadreur> searchencadreur);
}
