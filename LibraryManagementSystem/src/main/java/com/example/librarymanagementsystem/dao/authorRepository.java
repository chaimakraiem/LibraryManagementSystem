package com.example.librarymanagementsystem.dao;

import com.example.librarymanagementsystem.entities.author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface authorRepository extends JpaRepository<author,Long> {
    public Page<author> findByNomAuthContains(String mc, Pageable p);

    @Query("Select c from author c where c.id= :x")
    public List<author> getAuthorBYAuth(@Param("x") Long idC);
}
