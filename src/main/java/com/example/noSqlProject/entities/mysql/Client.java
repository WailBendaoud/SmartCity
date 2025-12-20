package com.example.noSqlProject.entities.mysql;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Client extends User {
    private Date dateInscription;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("client")
    private List<Paiement>paiement;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("client")
    private List<Abonnement> abonnements = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "point_fidelite_id", unique = true)
    private PointFidelite pointFidelite;

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public List<Paiement> getPaiement() {
        return paiement;
    }

    public void setPaiement(List<Paiement> paiement) {
        this.paiement = paiement;
    }

    public List<Abonnement> getAbonnements() {
        return abonnements;
    }

    public void setAbonnements(List<Abonnement> abonnements) {
        this.abonnements = abonnements;
    }

    public PointFidelite getPointFidelite() {
        return pointFidelite;
    }

    public void setPointFidelite(PointFidelite pointFidelite) {
        this.pointFidelite = pointFidelite;
    }


}
