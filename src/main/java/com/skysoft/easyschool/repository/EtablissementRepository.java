package com.skysoft.easyschool.repository;

import com.skysoft.easyschool.domain.Etablissement;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface EtablissementRepository extends JpaRepository<Etablissement, Long> {
    List<Etablissement> findAll(Specification<Etablissement> searchnom);

}
