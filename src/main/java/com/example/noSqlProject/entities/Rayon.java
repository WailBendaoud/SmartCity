package com.example.noSqlProject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rayon {
    //private String id;
    private String nom;
    private Integer capacite;
    private String couleur;
}
