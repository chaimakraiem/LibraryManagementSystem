package com.example.librarymanagementsystem.security.repository;


import com.example.librarymanagementsystem.security.entity.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<AppRole, String> {
}
