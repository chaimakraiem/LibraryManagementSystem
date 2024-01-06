package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.dao.membreRepository;
import com.example.librarymanagementsystem.entities.membre;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MembreService implements IMembreService {
    private membreRepository membreRepository;
    @Override
    public void saveMembre(membre u) {
        membreRepository.save(u);
    }

    @Override
    public List<membre> getAllMembres() {
        return membreRepository.findAll();
    }

    @Override
    public membre getMembreBId(Long idU) {
        return membreRepository.findById(idU).orElse(null);
    }

    @Override
    public void deleteMembre(Long idU) {
    membreRepository.deleteById(idU);
    }

    @Override
    public Page<membre> getMembreByMC(String mc, Pageable p) {
        return membreRepository.findByUsernameContains(mc,p);
    }
}




