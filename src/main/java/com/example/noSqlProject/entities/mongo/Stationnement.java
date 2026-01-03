package com.example.noSqlProject.entities.mongo;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDateTime;

@Document(collection ="Stationnement")
public class Stationnement {
    @Id
    private String id;
    private String matricule;
    private LocalDateTime dateHeureEntre;
    private LocalDateTime dateHeureSortie;
    private Parking parking;
    private Instant createdAt;

    public Stationnement(String id, String matricule, LocalDateTime dateHeureEntre, LocalDateTime dateHeureSortie, Parking parking, Instant createdAt) {
        this.id = id;
        this.matricule = matricule;
        this.dateHeureEntre = dateHeureEntre;
        this.dateHeureSortie = dateHeureSortie;
        this.parking = parking;
        this.createdAt = createdAt;
    }

    public Stationnement() {
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public LocalDateTime getDateHeureEntre() {
        return dateHeureEntre;
    }

    public void setDateHeureEntre(LocalDateTime dateHeureEntre) {
        this.dateHeureEntre = dateHeureEntre;
    }

    public LocalDateTime getDateHeureSortie() {
        return dateHeureSortie;
    }

    public void setDateHeureSortie(LocalDateTime dateHeureSortie) {
        this.dateHeureSortie = dateHeureSortie;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }
}
