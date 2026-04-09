package com.gestionformation.controller;

import com.gestionformation.entity.Domaine;
import com.gestionformation.service.DomaineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/domaines")
@RequiredArgsConstructor
public class DomaineController {
    private final DomaineService domaineService;

    @GetMapping
    public List<Domaine> getAll() { return domaineService.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Domaine> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(domaineService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Domaine> create(@Valid @RequestBody Domaine domaine) {
        return ResponseEntity.ok(domaineService.save(domaine));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Domaine> update(@PathVariable Integer id, @Valid @RequestBody Domaine domaine) {
        domaine.setId(id);
        return ResponseEntity.ok(domaineService.save(domaine));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        domaineService.delete(id);
        return ResponseEntity.noContent().build();
    }
}