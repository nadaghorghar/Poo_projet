package com.gestionformation.controller;

import com.gestionformation.entity.Formation;
import com.gestionformation.entity.Participant;
import com.gestionformation.service.FormationService;
import com.gestionformation.service.ParticipantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/formations")
@RequiredArgsConstructor
public class FormationController {

    private final FormationService formationService;
    private final ParticipantService participantService;  // Ajouter cette injection

    @GetMapping
    public List<Formation> getAll() {
        return formationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Formation> getById(@PathVariable Long id) {
        return ResponseEntity.ok(formationService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Formation> create(@Valid @RequestBody Formation formation) {
        return ResponseEntity.ok(formationService.save(formation));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Formation> update(@PathVariable Long id, @Valid @RequestBody Formation formation) {
        formation.setId(id);
        return ResponseEntity.ok(formationService.save(formation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        formationService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // NOUVEAU : Ajouter un participant à une formation
    @PostMapping("/{formationId}/participants/{participantId}")
    public ResponseEntity<Formation> addParticipant(
            @PathVariable Long formationId,
            @PathVariable Integer participantId) {  // Integer directement

        Formation formation = formationService.findById(formationId);
        Participant participant = participantService.findById(participantId);  // correspond au service

        if (!formation.getParticipants().contains(participant)) {
            formation.getParticipants().add(participant);
        }

        return ResponseEntity.ok(formationService.save(formation));
    }

    @DeleteMapping("/{formationId}/participants/{participantId}")
    public ResponseEntity<Formation> removeParticipant(
            @PathVariable Long formationId,
            @PathVariable Integer participantId) {  // Integer directement

        Formation formation = formationService.findById(formationId);
        Participant participant = participantService.findById(participantId);

        formation.getParticipants().remove(participant);

        return ResponseEntity.ok(formationService.save(formation));
    }}