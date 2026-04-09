package com.gestionformation.controller;

import com.gestionformation.entity.Structure;
import com.gestionformation.service.StructureService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/structures")
@RequiredArgsConstructor
public class StructureController {
    private final StructureService structureService;

    @GetMapping
    public List<Structure> getAll() { return structureService.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Structure> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(structureService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Structure> create(@Valid @RequestBody Structure structure) {
        return ResponseEntity.ok(structureService.save(structure));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Structure> update(@PathVariable Integer id, @Valid @RequestBody Structure structure) {
        structure.setId(id);
        return ResponseEntity.ok(structureService.save(structure));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        structureService.delete(id);
        return ResponseEntity.noContent().build();
    }
}