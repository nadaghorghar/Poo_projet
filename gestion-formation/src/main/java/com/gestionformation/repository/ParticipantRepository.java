package com.gestionformation.repository;
import com.gestionformation.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
    List<Participant> findByStructureId(Integer structureId);
    List<Participant> findByProfilId(Integer profilId);
}