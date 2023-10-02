package com.skysoft.easyschool.repository;

import com.skysoft.easyschool.domain.Tache;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TacheRepository extends JpaRepository<Tache, Long> {
    List<Tache> findAll(Specification<Tache> searchtache);
}
