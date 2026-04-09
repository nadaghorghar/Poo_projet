package com.gestionformation.service;

import com.gestionformation.entity.Structure;
import com.gestionformation.repository.StructureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StructureService {
    private final StructureRepository structureRepository;

    public List<Structure> findAll() { return structureRepository.findAll(); }
    public Structure findById(Integer id) { return structureRepository.findById(id).orElseThrow(); }
    public Structure save(Structure s) { return structureRepository.save(s); }
    public void delete(Integer id) { structureRepository.deleteById(id); }
}