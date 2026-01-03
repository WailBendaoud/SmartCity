package com.example.noSqlProject.entities.mysql;

import com.example.noSqlProject.enumeration.EtatAbonnement;
import com.example.noSqlProject.enumeration.TypeAbonnement;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity


public class Abonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TypeAbonnement typeAbonnement;
    private Date dateDebut;
    private Date dateFin;
    private Double prix;
    @Enumerated(EnumType.STRING)
    private EtatAbonnement etatAbonnement;
    private String parkingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    public Abonnement(Long id, TypeAbonnement typeAbonnement, Date dateDebut, Date dateFin, Double prix, EtatAbonnement etatAbonnement, String parkingId, Client client) {
        this.id = id;
        this.typeAbonnement = typeAbonnement;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prix = prix;
        this.etatAbonnement = etatAbonnement;
        this.parkingId = parkingId;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeAbonnement getTypeAbonnement() {
        return typeAbonnement;
    }

    public void setTypeAbonnement(TypeAbonnement typeAbonnement) {
        this.typeAbonnement = typeAbonnement;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public EtatAbonnement getEtatAbonnement() {
        return etatAbonnement;
    }

    public void setEtatAbonnement(EtatAbonnement etatAbonnement) {
        this.etatAbonnement = etatAbonnement;
    }

    public String getParkingId() {
        return parkingId;
    }

    public void setParkingId(String parkingId) {
        this.parkingId = parkingId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Abonnement() {
    }
}
