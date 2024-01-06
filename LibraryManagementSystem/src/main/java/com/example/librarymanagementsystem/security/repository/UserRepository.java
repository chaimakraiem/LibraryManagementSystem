package com.example.librarymanagementsystem.security.repository;


import com.example.librarymanagementsystem.security.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser,String> {
    public AppUser findAppUserByUsername(String username);


}
