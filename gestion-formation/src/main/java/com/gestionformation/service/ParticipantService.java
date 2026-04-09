package com.gestionformation.service;

import com.gestionformation.entity.Participant;
import com.gestionformation.repository.ParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipantService {
    private final ParticipantRepository participantRepository;

    public List<Participant> findAll() { return participantRepository.findAll(); }
    public Participant findById(Integer id) { return participantRepository.findById(id).orElseThrow(); }
    public Participant save(Participant p) { return participantRepository.save(p); }
    public void delete(Integer id) { participantRepository.deleteById(id); }
    public List<Participant> findByStructureId(Integer structureId) { return participantRepository.findByStructureId(structureId); }
    public List<Participant> findByProfilId(Integer profilId) { return participantRepository.findByProfilId(profilId); }
}