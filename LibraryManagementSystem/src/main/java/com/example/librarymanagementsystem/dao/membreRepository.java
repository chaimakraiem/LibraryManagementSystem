package com.example.librarymanagementsystem.dao;

import com.example.librarymanagementsystem.entities.membre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface membreRepository extends JpaRepository<membre,Long> {
    public Page<membre> findByUsernameContains(String mc, Pageable p);

    @Query("Select m from membre m where m.id= :x")
    public List<membre> getmembreById(@Param("x") Long idM);
}