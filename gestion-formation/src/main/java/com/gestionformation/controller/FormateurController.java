package com.gestionformation.controller;

import com.gestionformation.entity.Formateur;
import com.gestionformation.service.FormateurService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/formateurs")
@RequiredArgsConstructor
public class FormateurController {
    private final FormateurService formateurService;

    @GetMapping
    public List<Formateur> getAll() { return formateurService.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Formateur> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(formateurService.findById(id));
    }

    @GetMapping("/type/{type}")
    public List<Formateur> getByType(@PathVariable String type) {
        return formateurService.findByType(type);
    }

    @PostMapping
    public ResponseEntity<Formateur> create(@Valid @RequestBody Formateur formateur) {
        return ResponseEntity.ok(formateurService.save(formateur));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Formateur> update(@PathVariable Integer id, @Valid @RequestBody Formateur formateur) {
        formateur.setId(id);
        return ResponseEntity.ok(formateurService.save(formateur));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        formateurService.delete(id);
        return ResponseEntity.noContent().build();
    }
}