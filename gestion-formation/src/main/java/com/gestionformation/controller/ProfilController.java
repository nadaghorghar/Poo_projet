package com.gestionformation.controller;

import com.gestionformation.entity.Profil;
import com.gestionformation.service.ProfilService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/profils")
@RequiredArgsConstructor
public class ProfilController {
    private final ProfilService profilService;

    @GetMapping
    public List<Profil> getAll() { return profilService.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Profil> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(profilService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Profil> create(@Valid @RequestBody Profil profil) {
        return ResponseEntity.ok(profilService.save(profil));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profil> update(@PathVariable Integer id, @Valid @RequestBody Profil profil) {
        profil.setId(id);
        return ResponseEntity.ok(profilService.save(profil));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        profilService.delete(id);
        return ResponseEntity.noContent().build();
    }
}