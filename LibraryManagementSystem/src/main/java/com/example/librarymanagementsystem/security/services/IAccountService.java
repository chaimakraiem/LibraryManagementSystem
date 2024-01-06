package com.example.librarymanagementsystem.security.services;

import com.example.librarymanagementsystem.security.entity.AppUser;

public interface IAccountService {

    public void addRole(String role);
    public void addUser(String username,String password,String mail);
    public void addroleToUser(String usename,String role);
    public AppUser loadUserByUserName(String username);
}


