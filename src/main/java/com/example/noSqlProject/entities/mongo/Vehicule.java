package com.example.noSqlProject.entities.mongo;

import com.example.noSqlProject.entities.mysql.Client;
import com.example.noSqlProject.enumeration.TypeVehicule;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Vehicule")
public class Vehicule {
    @Id
    private String id;
    private String immatriculation;
    @Enumerated(EnumType.STRING)
    private TypeVehicule typeVehicule;
    private String marque;
    private String model;
    private String couleur;
    private Double emissionCo2;
    private Long client;
    private List<String> trajet;
    private List<Infraction>infractions;

    public Vehicule(String id, String immatriculation, TypeVehicule typeVehicule, String marque, String model, String couleur, Double emissionCo2, List<String> trajet, List<Infraction> infractions,Long client) {
        this.id = id;
        this.immatriculation = immatriculation;
        this.typeVehicule = typeVehicule;
        this.marque = marque;
        this.model = model;
        this.couleur = couleur;
        this.emissionCo2 = emissionCo2;
        this.trajet = trajet;
        this.infractions = infractions;
        this.client=client;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public TypeVehicule getTypeVehicule() {
        return typeVehicule;
    }

    public void setTypeVehicule(TypeVehicule typeVehicule) {
        this.typeVehicule = typeVehicule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public Double getEmissionCo2() {
        return emissionCo2;
    }

    public void setEmissionCo2(Double emissionCo2) {
        this.emissionCo2 = emissionCo2;
    }

    public List<String> getTrajet() {
        return trajet;
    }

    public void setTrajet(List<String> trajet) {
        this.trajet = trajet;
    }

    public List<Infraction> getInfractions() {
        return infractions;
    }

    public void setInfractions(List<Infraction> infractions) {
        this.infractions = infractions;
    }

    public Long getClient() {
        return client;
    }

    public void setClient(Long client) {
        this.client = client;
    }

    public Vehicule() {
    }
}
