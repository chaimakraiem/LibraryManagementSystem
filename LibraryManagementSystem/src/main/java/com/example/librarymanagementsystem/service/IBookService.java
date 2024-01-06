package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.entities.book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IBookService {

    public void saveBook(book p,MultipartFile mf) throws IOException;
    public List<book> getAllBooks();
    public Page<book> getBooksByMc(String mc, Pageable p);
    public List<book> getBookBCat(Long idCat);
    public List<book> getBookBAuth(Long idAuth);
    public void deleteBook(Long id);
    public book getBookById(Long id);
    public byte[] getImage(Long id) throws IOException;

}
