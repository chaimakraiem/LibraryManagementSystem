package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.entities.author;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AuthorService implements  IAuthorService{
    private com.example.librarymanagementsystem.dao.authorRepository authorRepository;
    @Override
    public void saveAuthor(author a) {
        authorRepository.save(a);
    }
    @Override
    public List<author> getAllAuthors() {
        return authorRepository.findAll();
    }
    @Override
    public author getAuthorBId(Long idAut) {
        return authorRepository.findById(idAut).orElse(null);
    }

    @Override
    public void deleteAuthor(Long idAut) {
        authorRepository.deleteById(idAut);
    }
    @Override
    public Page<author> getAuthorByMC(String mc, Pageable p) {
        return authorRepository.findByNomAuthContains(mc, p);
    }

}
