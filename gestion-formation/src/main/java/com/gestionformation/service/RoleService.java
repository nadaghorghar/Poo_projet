package com.gestionformation.service;

import com.gestionformation.entity.Role;
import com.gestionformation.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public List<Role> findAll() { return roleRepository.findAll(); }
    public Role findById(Integer id) { return roleRepository.findById(id).orElseThrow(); }
    public Role save(Role r) { return roleRepository.save(r); }
    public void delete(Integer id) { roleRepository.deleteById(id); }
}