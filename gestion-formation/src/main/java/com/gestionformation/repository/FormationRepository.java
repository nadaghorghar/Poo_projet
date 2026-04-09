package com.gestionformation.repository;
import com.gestionformation.entity.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface FormationRepository extends JpaRepository<Formation, Long> {
    List<Formation> findByAnnee(Integer annee);
    List<Formation> findByDomaineId(Integer domaineId);
    long countByAnnee(Integer annee);
}