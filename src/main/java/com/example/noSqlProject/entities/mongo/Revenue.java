package com.example.noSqlProject.entities.mongo;

import com.example.noSqlProject.enumeration.TypeCharge;
import com.example.noSqlProject.enumeration.TypeRevenue;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Date;
@Document(collection = "Revenue")

public class Revenue {
    @Id
    private String  id;
    @Enumerated(EnumType.STRING)
    private TypeRevenue type;
    private Double montant;
    private Date dateRevenu;
    private String description;
    private Parking parking;
    private Instant createdAt;

    public Revenue() {
    }

    public Revenue(String id, TypeRevenue type, Double montant, Date dateRevenu, String description, Parking parking, Instant createdAt) {
        this.id = id;
        this.type = type;
        this.montant = montant;
        this.dateRevenu = dateRevenu;
        this.description = description;
        this.parking = parking;
        this.createdAt = createdAt;
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

    public TypeRevenue getType() {
        return type;
    }

    public void setType(TypeRevenue type) {
        this.type = type;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Date getDateRevenu() {
        return dateRevenu;
    }

    public void setDateRevenu(Date dateRevenu) {
        this.dateRevenu = dateRevenu;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }
}
