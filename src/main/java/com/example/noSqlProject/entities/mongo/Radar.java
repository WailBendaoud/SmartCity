package com.example.noSqlProject.entities.mongo;

import com.example.noSqlProject.enumeration.TypeRadar;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Document(collection ="Radar")

public class Radar {
    @Id
    private String id;
    @Enumerated(EnumType.STRING)
    private TypeRadar typeRadar;
    private Double vitesseMax;
    private String  position;
    private List<String>infractions;
    private Avenue avenue;
    private Instant createdAt;


    public Radar() {
    }

    public Radar(String id, TypeRadar typeRadar, Double vitesseMax, String position, List<String> infractions, Avenue avenue, Instant createdAt) {
        this.id = id;
        this.typeRadar = typeRadar;
        this.vitesseMax = vitesseMax;
        this.position = position;
        this.infractions = infractions;
        this.avenue = avenue;
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

    public TypeRadar getTypeRadar() {
        return typeRadar;
    }

    public void setTypeRadar(TypeRadar typeRadar) {
        this.typeRadar = typeRadar;
    }

    public Double getVitesseMax() {
        return vitesseMax;
    }

    public void setVitesseMax(Double vitesseMax) {
        this.vitesseMax = vitesseMax;
    }

    public String  getPosition() {
        return position;
    }

    public void setPosition(String  position) {
        this.position = position;
    }

    public List<String> getInfractions() {
        return infractions;
    }

    public void setInfractions(List<String> infractions) {
        this.infractions = infractions;
    }

    public Avenue getAvenue() {
        return avenue;
    }

    public void setAvenue(Avenue avenue) {
        this.avenue = avenue;
    }
}
