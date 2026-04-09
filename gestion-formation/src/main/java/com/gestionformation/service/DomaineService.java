package com.gestionformation.service;

import com.gestionformation.entity.Domaine;
import com.gestionformation.repository.DomaineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DomaineService {
    private final DomaineRepository domaineRepository;

    public List<Domaine> findAll() { return domaineRepository.findAll(); }
    public Domaine findById(Integer id) { return domaineRepository.findById(id).orElseThrow(); }
    public Domaine save(Domaine d) { return domaineRepository.save(d); }
    public void delete(Integer id) { domaineRepository.deleteById(id); }
}