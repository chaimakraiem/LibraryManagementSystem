package com.example.librarymanagementsystem;

import com.example.librarymanagementsystem.security.services.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication

public class LibraryManagementSystemApplication{

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementSystemApplication.class, args);
    }
    @Bean
    public BCryptPasswordEncoder PasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    //@Bean
    CommandLineRunner commandLineRunner(IAccountService accountService){
        return args -> {
            accountService.addRole("ADMIN");
            accountService.addRole("USER");
            accountService.addUser("user","123","user@gmail.com");
            accountService.addUser("admin","1234","admin@gmail.com");
            accountService.addroleToUser("user","USER");
            accountService.addroleToUser("admin","ADMIN");
            accountService.addroleToUser("admin","USER");

        };
    }


}
