package com.example.noSqlProject.entities.mysql;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Gestionnaire extends User {
    private Double salaire;
    private Date dateEmboche;
    private String parkingId;




    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

    public Date getDateEmboche() {
        return dateEmboche;
    }

    public void setDateEmboche(Date dateEmboche) {
        this.dateEmboche = dateEmboche;
    }

    public String getParkingId() {
        return parkingId;
    }

    public void setParkingId(String parkingId) {
        this.parkingId = parkingId;
    }
}

