package com.example.noSqlProject.entities.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Rayon {
    //private String id;
    private String nom;
    private Integer capacite;
    private String couleur;

    public Rayon(String nom, Integer capacite, String couleur) {
        this.nom = nom;
        this.capacite = capacite;
        this.couleur = couleur;
    }

    public Rayon() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getCapacite() {
        return capacite;
    }

    public void setCapacite(Integer capacite) {
        this.capacite = capacite;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
}
