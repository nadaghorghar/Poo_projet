package com.gestionformation.repository;
import com.gestionformation.entity.Employeur;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmployeurRepository extends JpaRepository<Employeur, Integer> {}