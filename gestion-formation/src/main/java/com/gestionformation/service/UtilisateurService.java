package com.gestionformation.service;

import com.gestionformation.entity.Utilisateur;
import com.gestionformation.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;

    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur findById(Integer id) {
        return utilisateurRepository.findById(id).orElseThrow();
    }

    public Utilisateur save(Utilisateur u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        return utilisateurRepository.save(u);
    }

    public Utilisateur update(Integer id, Utilisateur u) {
        Utilisateur existing = findById(id);
        existing.setLogin(u.getLogin());
        existing.setRole(u.getRole());
        if (u.getPassword() != null && !u.getPassword().isBlank()) {
            existing.setPassword(passwordEncoder.encode(u.getPassword()));
        }
        return utilisateurRepository.save(existing);
    }

    public void delete(Integer id) {
        utilisateurRepository.deleteById(id);
    }
}
