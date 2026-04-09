package com.gestionformation.repository;
import com.gestionformation.entity.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FormateurRepository extends JpaRepository<Formateur, Integer> {
    List<Formateur> findByType(String type);
}
