package com.skysoft.easyschool.repository.specification;

import com.skysoft.easyschool.domain.Projet;
import org.springframework.data.jpa.domain.Specification;

public class ProjetSpecification {

    private static Specification<Projet> searchnom(String nom_projet) {
        return (Specification<Projet>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("nom_projet"), "%".concat(nom_projet).concat("%"));
    }
    private static Specification<Projet> searchdate(String date_creation) {
        return (Specification<Projet>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("date_creation"), "%".concat(date_creation).concat("%"));
    }

    public static Specification<Projet> searchprojet(String nom_projet, String date_creation) {
        Specification<Projet> specification = null;

        if (nom_projet != null) {
            specification = Specification.where(specification).and(ProjetSpecification.searchnom(nom_projet));
        }
        if (date_creation != null) {
            specification = Specification.where(specification).and(ProjetSpecification.searchdate(date_creation));
        }
        return specification;
    }
}
