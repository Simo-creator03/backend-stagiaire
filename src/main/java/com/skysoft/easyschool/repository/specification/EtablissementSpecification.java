package com.skysoft.easyschool.repository.specification;

import com.skysoft.easyschool.domain.Etablissement;
import org.springframework.data.jpa.domain.Specification;

public class EtablissementSpecification {
    public static Specification<Etablissement> searchetablissement(String nom) {
        return (Specification<Etablissement>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("nom"), "%".concat(nom).concat("%"));
    }

}
