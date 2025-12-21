package com.example.noSqlProject.entities.mongo;


import com.example.noSqlProject.enumeration.Degres;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document
public class Infraction {
    @Id
    private String id;
    private Double vitesse;
    private LocalDateTime date;
    @Enumerated(EnumType.STRING)
    private Degres degres;
    private Radar radar;
    private Vehicule vehicule;

    public Infraction(String id, Double vitesse, LocalDateTime date, Degres degres, Radar radar, Vehicule vehicule) {
        this.id = id;
        this.vitesse = vitesse;
        this.date = date;
        this.degres = degres;
        this.radar = radar;
        this.vehicule = vehicule;
    }

    public Infraction() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getVitesse() {
        return vitesse;
    }

    public void setVitesse(Double vitesse) {
        this.vitesse = vitesse;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Degres getDegres() {
        return degres;
    }

    public void setDegres(Degres degres) {
        this.degres = degres;
    }

    public Radar getRadar() {
        return radar;
    }

    public void setRadar(Radar radar) {
        this.radar = radar;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }
}
