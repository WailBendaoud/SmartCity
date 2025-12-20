package com.example.noSqlProject.entities.mysql;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor

public class PointFidelite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer solde;
    private Date dateMaj;

    public PointFidelite(Integer nb){
        this.solde=nb;
    }

    public PointFidelite() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSolde() {
        return solde;
    }

    public void setSolde(Integer solde) {
        this.solde = solde;
    }

    public Date getDateMaj() {
        return dateMaj;
    }

    public void setDateMaj(Date dateMaj) {
        this.dateMaj = dateMaj;
    }
}
