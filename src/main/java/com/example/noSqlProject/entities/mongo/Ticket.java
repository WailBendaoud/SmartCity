package com.example.noSqlProject.entities.mongo;

import com.example.noSqlProject.entities.mysql.Paiement;
import com.example.noSqlProject.enumeration.EtatPaiementTicket;
import com.example.noSqlProject.enumeration.TypePaiement;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "Ticket")

public class Ticket {
    @Id
    private String id;
    private LocalDateTime heureEntre;
    private LocalDateTime heureSortie;
    private Double prix;
    @Enumerated(EnumType.STRING)
    private TypePaiement type;
    @Enumerated(EnumType.STRING)
    private EtatPaiementTicket etat;
    private Parking p;
    private Vehicule vehicule;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getHeureEntre() {
        return heureEntre;
    }

    public void setHeureEntre(LocalDateTime heureEntre) {
        this.heureEntre = heureEntre;
    }

    public LocalDateTime getHeureSortie() {
        return heureSortie;
    }

    public void setHeureSortie(LocalDateTime heureSortie) {
        this.heureSortie = heureSortie;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public TypePaiement getType() {
        return type;
    }

    public void setType(TypePaiement type) {
        this.type = type;
    }

    public EtatPaiementTicket getEtat() {
        return etat;
    }

    public void setEtat(EtatPaiementTicket etat) {
        this.etat = etat;
    }

    public Parking getP() {
        return p;
    }

    public void setP(Parking p) {
        this.p = p;
    }

    public Ticket() {
    }

    public Ticket(String id, LocalDateTime heureEntre, LocalDateTime heureSortie, Double prix, TypePaiement type, EtatPaiementTicket etat, Parking p, Vehicule vehicule) {
        this.id = id;
        this.heureEntre = heureEntre;
        this.heureSortie = heureSortie;
        this.prix = prix;
        this.type = type;
        this.etat = etat;
        this.p = p;
        this.vehicule = vehicule;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }
}
