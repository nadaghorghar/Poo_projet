package com.gestionformation.service;

import com.gestionformation.entity.Employeur;
import com.gestionformation.repository.EmployeurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeurService {
    private final EmployeurRepository employeurRepository;

    public List<Employeur> findAll() { return employeurRepository.findAll(); }
    public Employeur findById(Integer id) { return employeurRepository.findById(id).orElseThrow(); }
    public Employeur save(Employeur e) { return employeurRepository.save(e); }
    public void delete(Integer id) { employeurRepository.deleteById(id); }
}