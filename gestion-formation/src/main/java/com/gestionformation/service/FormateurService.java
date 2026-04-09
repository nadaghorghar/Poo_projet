package com.gestionformation.service;

import com.gestionformation.entity.Formateur;
import com.gestionformation.repository.FormateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FormateurService {
    private final FormateurRepository formateurRepository;

    public List<Formateur> findAll() { return formateurRepository.findAll(); }
    public Formateur findById(Integer id) { return formateurRepository.findById(id).orElseThrow(); }
    public Formateur save(Formateur f) { return formateurRepository.save(f); }
    public void delete(Integer id) { formateurRepository.deleteById(id); }
    public List<Formateur> findByType(String type) { return formateurRepository.findByType(type); }
}