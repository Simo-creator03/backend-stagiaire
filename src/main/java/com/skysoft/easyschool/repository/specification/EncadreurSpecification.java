package com.skysoft.easyschool.repository.specification;

import com.skysoft.easyschool.domain.Encadreur;
import org.springframework.data.jpa.domain.Specification;

public class EncadreurSpecification {
    private static Specification<Encadreur> searchnom(String nom) {
        return (Specification<Encadreur>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("nom"), "%".concat(nom).concat("%"));
    }

    private static Specification<Encadreur> searchprenom(String prenom_encadreur) {
        return (Specification<Encadreur>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("prenom_encadreur"), prenom_encadreur);
    }

    public static Specification<Encadreur> searchencadreur(String nom, String prenom_encadreur) {
        Specification<Encadreur> specification = null;
        if (nom != null) {
            specification = Specification.where(specification).and(EncadreurSpecification.searchnom(nom));
        }

        if (prenom_encadreur != null) {
            specification = Specification.where(specification).and(EncadreurSpecification.searchprenom(prenom_encadreur));
        }
        return specification;
    }
}
