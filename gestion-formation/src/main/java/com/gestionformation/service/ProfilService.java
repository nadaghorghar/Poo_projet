package com.gestionformation.service;

import com.gestionformation.entity.Profil;
import com.gestionformation.repository.ProfilRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfilService {
    private final ProfilRepository profilRepository;

    public List<Profil> findAll() { return profilRepository.findAll(); }
    public Profil findById(Integer id) { return profilRepository.findById(id).orElseThrow(); }
    public Profil save(Profil p) { return profilRepository.save(p); }
    public void delete(Integer id) { profilRepository.deleteById(id); }
}