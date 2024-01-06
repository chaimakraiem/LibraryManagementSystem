package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.entities.category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategorieService {
        public void saveCategorie(category c);
        public List<category> getAllCategories();
        public category getCategoriesBId(Long idC);
        public void deleteCategorie(Long idC);
        public Page<category> getCategoryByMC(String mc, Pageable p);

}
