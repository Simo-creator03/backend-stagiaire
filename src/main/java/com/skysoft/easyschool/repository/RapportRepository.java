package com.skysoft.easyschool.repository;

import com.skysoft.easyschool.domain.Rapport;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RapportRepository extends JpaRepository<Rapport, Long> {
    List<Rapport> findAll(Specification<Rapport> searchrapport);
}
