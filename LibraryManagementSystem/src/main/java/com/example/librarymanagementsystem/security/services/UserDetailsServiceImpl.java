package com.example.librarymanagementsystem.security.services;

import com.example.librarymanagementsystem.security.entity.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;


import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service

public class UserDetailsServiceImpl implements UserDetailsService {
    IAccountService accountService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser=accountService.loadUserByUserName(username);
        List<GrantedAuthority> authorities=new ArrayList<>();
        appUser.getRoles().forEach(e->authorities.add(new SimpleGrantedAuthority(e.getRole())));
        return new User(appUser.getUsername(),appUser.getPassword(),authorities);
    }
}

