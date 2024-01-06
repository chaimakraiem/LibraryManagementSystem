package com.example.librarymanagementsystem.dao;

import com.example.librarymanagementsystem.entities.book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface bookRepository extends JpaRepository<book,Long> {
    public Page<book> findByTitleContains(String mc, Pageable p);
    @Query("Select p from book p where p.category.id= :x")
    public List<book> getBooksBYCat(@Param("x") Long idC);
    @Query("Select p from book p where p.author.id= :x")
    public List<book> getBooksBYAuth(@Param("x") Long idC);

}
