package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.dao.CategorieRepository;
import com.example.librarymanagementsystem.entities.category;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service

public class CategorieService implements ICategorieService{

    private CategorieRepository categorieRepository;

    @Override
    public void saveCategorie(category c) {
        categorieRepository.save(c);
    }
    @Override
    public List<category> getAllCategories() {
        return categorieRepository.findAll();
    }
    @Override
    public category getCategoriesBId(Long idC) {
        return categorieRepository.findById(idC).orElse(null);
    }
    @Override
    public void deleteCategorie(Long idC) {
        categorieRepository.deleteById(idC);
    }
    @Override
    public Page<category> getCategoryByMC(String mc, Pageable p) {
        return categorieRepository.findByNomCatContains(mc, p);    }
}
