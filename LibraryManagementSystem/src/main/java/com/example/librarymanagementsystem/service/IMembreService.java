package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.entities.membre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMembreService {
    public void saveMembre(membre u);
    public List<membre> getAllMembres();
    public membre getMembreBId(Long idU);
    public void deleteMembre(Long idU);
    public Page<membre> getMembreByMC(String mc, Pageable p);
}
