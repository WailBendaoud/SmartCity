package com.example.noSqlProject.entities.mongo;

import com.example.noSqlProject.entities.mysql.Gestionnaire;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection ="Parking")


public class Parking {
    @Id
    private String id;
    private String nom;
    private Integer capacite;
    private String localisation;
    private Double prixParHeure;
    private Gestionnaire gestionnaire;
    private List<Rayon>rayons;//
    private List<Long>abonnement;
    private List<String>tickets;//
    private List<String> revenues;//
    private List<String> charges;//
    private Avenue avenue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getCapacite() {
        return capacite;
    }

    public void setCapacite(Integer capacite) {
        this.capacite = capacite;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public Double getPrixParHeure() {
        return prixParHeure;
    }

    public void setPrixParHeure(Double prixParHeure) {
        this.prixParHeure = prixParHeure;
    }

    public Gestionnaire getGestionnaire() {
        return gestionnaire;
    }

    public void setGestionnaire(Gestionnaire gestionnaire) {
        this.gestionnaire = gestionnaire;
    }

    public List<Rayon> getRayons() {
        return rayons;
    }

    public void setRayons(List<Rayon> rayons) {
        this.rayons = rayons;
    }

    public List<Long> getAbonnement() {
        return abonnement;
    }

    public void setAbonnement(List<Long> abonnement) {
        this.abonnement = abonnement;
    }

    public List<String> getTickets() {
        return tickets;
    }

    public void setTickets(List<String> tickets) {
        this.tickets = tickets;
    }

    public List<String> getRevenues() {
        return revenues;
    }

    public void setRevenues(List<String> revenues) {
        this.revenues = revenues;
    }

    public List<String> getCharges() {
        return charges;
    }

    public void setCharges(List<String> charges) {
        this.charges = charges;
    }

    public Avenue getAvenue() {
        return avenue;
    }

    public void setAvenue(Avenue avenue) {
        this.avenue = avenue;
    }

    public Parking(String id, String nom, Integer capacite, String localisation, Double prixParHeure, Gestionnaire gestionnaire, List<Rayon> rayons, List<Long> abonnement, List<String> tickets, List<String> revenues, List<String> charges, Avenue avenue) {
        this.id = id;
        this.nom = nom;
        this.capacite = capacite;
        this.localisation = localisation;
        this.prixParHeure = prixParHeure;
        this.gestionnaire = gestionnaire;
        this.rayons = rayons;
        this.abonnement = abonnement;
        this.tickets = tickets;
        this.revenues = revenues;
        this.charges = charges;
        this.avenue = avenue;
    }

    public Parking() {
    }


}
