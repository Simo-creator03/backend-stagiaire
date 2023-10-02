package com.skysoft.easyschool.repository.specification;

import com.skysoft.easyschool.domain.Tache;
import org.springframework.data.jpa.domain.Specification;

public class TacheSpecification {
    public static Specification<Tache> searchobjectif(String objectif_tache) {
        return (Specification<Tache>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("objectif_tache"), "%".concat(objectif_tache).concat("%"));
    }
    public static Specification<Tache> searchstatut(String statut) {
        return (Specification<Tache>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("statut"), "%".concat(statut).concat("%"));
    }
    public static Specification<Tache> searchtache(String objectif_tache, String statut) {
        Specification<Tache> specification = null;

        if (objectif_tache != null) {
            specification = Specification.where(specification).and(TacheSpecification.searchobjectif(objectif_tache));
        }
        if (statut != null) {
            specification = Specification.where(specification).and(TacheSpecification.searchstatut(statut));
        }
        return specification;
    }
}
