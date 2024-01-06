package com.example.librarymanagementsystem.dao;


import com.example.librarymanagementsystem.entities.category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategorieRepository extends JpaRepository<category,Long>{
    public Page<category> findByNomCatContains(String mc, Pageable p);
    @Query("Select c from category c where c.id= :x")
    public List<category> getCategorieBYCat(@Param("x") Long idC);
}
