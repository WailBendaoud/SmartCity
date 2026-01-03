package com.example.noSqlProject.entities.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Document(collection = "Trajet")

public class Trajet {
    @Id
    private String id;
    private String pointDepart;
    private String poitArrivee;
    private String heureDepart;
    private String heureArrivee;
    private Double distance;
    private Vehicule vehicule;
    private Instant createdAt;

    public Trajet(String id, String pointDepart, String poitArrivee, String heureDepart, String heureArrivee, Double distance, Vehicule vehicule, Instant createdAt) {
        this.id = id;
        this.pointDepart = pointDepart;
        this.poitArrivee = poitArrivee;
        this.heureDepart = heureDepart;
        this.heureArrivee = heureArrivee;
        this.distance = distance;
        this.vehicule = vehicule;
        this.createdAt = createdAt;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Trajet() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPointDepart() {
        return pointDepart;
    }

    public void setPointDepart(String pointDepart) {
        this.pointDepart = pointDepart;
    }

    public String getPoitArrivee() {
        return poitArrivee;
    }

    public void setPoitArrivee(String poitArrivee) {
        this.poitArrivee = poitArrivee;
    }

    public String getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(String heureDepart) {
        this.heureDepart = heureDepart;
    }

    public String getHeureArrivee() {
        return heureArrivee;
    }

    public void setHeureArrivee(String heureArrivee) {
        this.heureArrivee = heureArrivee;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }
}
