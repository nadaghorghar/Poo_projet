package com.gestionformation.controller;

import com.gestionformation.entity.Employeur;
import com.gestionformation.service.EmployeurService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employeurs")
@RequiredArgsConstructor
public class EmployeurController {
    private final EmployeurService employeurService;

    @GetMapping
    public List<Employeur> getAll() { return employeurService.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Employeur> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(employeurService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Employeur> create(@Valid @RequestBody Employeur employeur) {
        return ResponseEntity.ok(employeurService.save(employeur));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employeur> update(@PathVariable Integer id, @Valid @RequestBody Employeur employeur) {
        employeur.setId(id);
        return ResponseEntity.ok(employeurService.save(employeur));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        employeurService.delete(id);
        return ResponseEntity.noContent().build();
    }
}