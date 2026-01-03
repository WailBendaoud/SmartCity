package com.example.noSqlProject.entities.mysql;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double montant;

    private Date datePaiment;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "abonnement_id") // clé étrangère pour Abonnement
    private Abonnement abonnement;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getMontant() { return montant; }
    public void setMontant(Double montant) { this.montant = montant; }

    public Date getDatePaiment() { return datePaiment; }
    public void setDatePaiment(Date datePaiment) { this.datePaiment = datePaiment; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public Abonnement getAbonnement() { return abonnement; }
    public void setAbonnement(Abonnement abonnement) { this.abonnement = abonnement; }

    public Paiement(Long id, Double montant, Date datePaiment, Client client, Abonnement abonnement) {
        this.id = id;
        this.montant = montant;
        this.datePaiment = datePaiment;
        this.client = client;
        this.abonnement = abonnement;
    }

    public Paiement() {
    }
}

