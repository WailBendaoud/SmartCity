package com.example.noSqlProject.entities.mongo;

import com.example.noSqlProject.enumeration.TypeCharge;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection ="Charge")
public class Charge {
    @Id
    private String  id;
    @Enumerated(EnumType.STRING)
    private TypeCharge type;
    private Double montant;
    private Date dateCharge;
    private String description;
    private Parking parking;

    public Charge(String id, TypeCharge type, Double montant, Date dateCharge, String description, Parking parking) {
        this.id = id;
        this.type = type;
        this.montant = montant;
        this.dateCharge = dateCharge;
        this.description = description;
        this.parking = parking;
    }

    public Charge() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TypeCharge getType() {
        return type;
    }

    public void setType(TypeCharge type) {
        this.type = type;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Date getDateCharge() {
        return dateCharge;
    }

    public void setDateCharge(Date dateCharge) {
        this.dateCharge = dateCharge;
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
