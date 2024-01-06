package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.entities.book;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@AllArgsConstructor
@Service
public class BookService implements IBookService{
    private com.example.librarymanagementsystem.dao.bookRepository bookRepository;
    @Override
    public void saveBook(book b, MultipartFile mf) throws IOException {
        if(!mf.isEmpty()) {
            String image = saveImage(mf);
            b.setImage(image);
        }
        bookRepository.save(b);
    }
    @Override
    public List<book> getAllBooks() {
        return bookRepository.findAll();
    }
    @Override
    public Page<book> getBooksByMc(String mc, Pageable p) {
        return bookRepository.findByTitleContains(mc, p);
    }

    @Override
    public List<book> getBookBCat(Long idCat) {
        return bookRepository.getBooksBYCat(idCat);
    }

    @Override
    public List<book> getBookBAuth(Long idAuth) {
        return bookRepository.getBooksBYAuth(idAuth);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
    @Override
    public byte[] getImage(Long id) throws IOException {
        File f=new ClassPathResource("static/images").getFile();
        String chemin=f.getAbsolutePath();
        Path p= Paths.get(chemin,getBookById(id).getImage());
        return Files.readAllBytes(p);
    }

    private String saveImage(MultipartFile mf) throws IOException {
        String monphoto = mf.getOriginalFilename();
        assert monphoto != null;
        String tab[]= monphoto.split("\\.");
        String newName = tab[0]+System.currentTimeMillis()+"."+tab[1];
        File file =new ClassPathResource("static/images").getFile();
        String chemin =file.getAbsolutePath();
        Path p= Paths.get(chemin,newName);
        Files.write(p,mf.getBytes());

        return  newName;
    }
}
