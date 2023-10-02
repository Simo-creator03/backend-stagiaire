package com.skysoft.easyschool.repository.specification;

import com.skysoft.easyschool.domain.Rapport;
import org.springframework.data.jpa.domain.Specification;

public class RapportSpecification {

    private static Specification<Rapport> searchtitre(String titre_rapport) {
        return (Specification<Rapport>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("titre_rapport"), "%".concat(titre_rapport).concat("%"));
    }
    private static Specification<Rapport> searchdate(String date_envoi) {
        return (Specification<Rapport>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("date_envoi"), "%".concat(date_envoi).concat("%"));
    }

    public static Specification<Rapport> searchrapport(String titre_rapport, String date_envoi) {
        Specification<Rapport> specification = null;

        if (titre_rapport != null) {
            specification = Specification.where(specification).and(RapportSpecification.searchtitre(titre_rapport));
        }
        if (date_envoi != null) {
            specification = Specification.where(specification).and(RapportSpecification.searchdate(date_envoi));
        }
        return specification;
    }
}
