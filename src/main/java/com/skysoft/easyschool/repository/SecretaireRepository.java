package com.skysoft.easyschool.repository;

import com.skysoft.easyschool.domain.Secretaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface SecretaireRepository extends JpaRepository<Secretaire, Long> {
    Optional<Secretaire> findByNom(String nom);
}
