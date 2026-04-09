package com.gestionformation.controller;

import com.gestionformation.entity.Participant;
import com.gestionformation.service.ParticipantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/participants")
@RequiredArgsConstructor
public class ParticipantController {
    private final ParticipantService participantService;

    @GetMapping
    public List<Participant> getAll() { return participantService.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Participant> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(participantService.findById(id));
    }

    @GetMapping("/structure/{structureId}")
    public List<Participant> getByStructure(@PathVariable Integer structureId) {
        return participantService.findByStructureId(structureId);
    }

    @GetMapping("/profil/{profilId}")
    public List<Participant> getByProfil(@PathVariable Integer profilId) {
        return participantService.findByProfilId(profilId);
    }

    @PostMapping
    public ResponseEntity<Participant> create(@Valid @RequestBody Participant participant) {
        return ResponseEntity.ok(participantService.save(participant));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Participant> update(@PathVariable Integer id, @Valid @RequestBody Participant participant) {
        participant.setId(id);
        return ResponseEntity.ok(participantService.save(participant));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        participantService.delete(id);
        return ResponseEntity.noContent().build();
    }
}