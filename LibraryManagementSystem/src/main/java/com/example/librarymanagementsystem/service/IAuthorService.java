package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.entities.author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAuthorService {
        public void saveAuthor(author a);
        public List<author> getAllAuthors();
        public author getAuthorBId(Long idAut);
        public void deleteAuthor(Long idAut);
    public Page<author> getAuthorByMC(String mc, Pageable p);

    }

