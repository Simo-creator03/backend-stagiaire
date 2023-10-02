package com.skysoft.easyschool.repository.specification;

import com.skysoft.easyschool.domain.Rapport;
import com.skysoft.easyschool.domain.Stagiaire;
import org.springframework.data.jpa.domain.Specification;

public class StagiaireSpecification {

    static Specification<Stagiaire> searchnom(String nom) {
        return (Specification<Stagiaire>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("nom"), "%".concat(nom).concat("%"));
    }

    private static Specification<Stagiaire> searchprenom(String prenom) {
        return (Specification<Stagiaire>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("prenom"),prenom);
    }
    private static Specification<Stagiaire> searchdomaine(String domaine) {
        return (Specification<Stagiaire>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("domaine"), domaine);
    }

    public static Specification<Stagiaire> searchstagiaire(String nom, String prenom, String domaine) {
        Specification<Stagiaire> specification = null;
        if (nom != null) {
            specification = Specification.where(specification).and(StagiaireSpecification.searchnom(nom));
        }

        if (prenom != null) {
            specification = Specification.where(specification).and(StagiaireSpecification.searchprenom(prenom));
        }
        if (domaine != null) {
            specification = Specification.where(specification).and(StagiaireSpecification.searchdomaine(domaine));
        }
        return specification;
    }
}
