package com.example.librarymanagementsystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isbn;
    private String title;
    private String description;
    private String image;
    private int quantite;
    @ManyToOne
    @NotNull
    private author author;

    @ManyToOne
    @NotNull
    private category category;

}

