package com.skysoft.easyschool.repository;

import com.skysoft.easyschool.domain.Projet;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long> {
    List<Projet> findAll(Specification<Projet> searchprojet);
}
