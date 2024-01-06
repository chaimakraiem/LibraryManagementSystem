package com.example.librarymanagementsystem.security;

import com.example.librarymanagementsystem.security.services.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
    PasswordEncoder passwordEncoder;
    UserDetailsServiceImpl userDetailsServiceImp;

    // @Bean
    InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        return new InMemoryUserDetailsManager(
                User.withUsername("user").password(passwordEncoder.encode("1234")).roles("USER").build(),
                User.withUsername("admin").password(passwordEncoder.encode("1234")).roles("ADMIN","USER").build()

        );}

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin(form->form.loginPage("/login").permitAll());
        httpSecurity.authorizeHttpRequests(authorize->authorize.requestMatchers("/admin/**").hasAuthority("ADMIN"));
        httpSecurity.authorizeHttpRequests(authorize->authorize.requestMatchers("/user/**").hasAuthority("USER"));
        httpSecurity.authorizeHttpRequests(authorize->authorize.requestMatchers("/images/**").permitAll());
        httpSecurity.authorizeHttpRequests(authorize-> authorize.anyRequest().authenticated());
        httpSecurity.exceptionHandling((exception->exception.accessDeniedPage("/errorPage")));

        httpSecurity.userDetailsService(userDetailsServiceImp);
        return httpSecurity.build();
    }


}
