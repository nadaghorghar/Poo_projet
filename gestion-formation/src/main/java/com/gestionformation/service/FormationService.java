package com.gestionformation.service;

import com.gestionformation.entity.Formation;
import com.gestionformation.repository.FormationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional  // ajouter ceci
public class FormationService {
    private final FormationRepository formationRepository;

    public List<Formation> findAll() { return formationRepository.findAll(); }
    public Formation findById(Long id) { return formationRepository.findById(id).orElseThrow(); }

    @Transactional
    public Formation save(Formation f) { return formationRepository.save(f); }

    public void delete(Long id) { formationRepository.deleteById(id); }
    public List<Formation> findByAnnee(Integer annee) { return formationRepository.findByAnnee(annee); }
}