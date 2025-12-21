package com.example.noSqlProject.entities.mongo;

import com.example.noSqlProject.enumeration.Etat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Document

public class Camera {
    //@Id
    private String id;
    private String modeles;
    private Double angleVision;
    private String resolution;
    private String position;
    private Etat etat;

    public Camera(String id, String modeles, Double angleVision, String resolution, String position, Etat etat) {
        this.id = id;
        this.modeles = modeles;
        this.angleVision = angleVision;
        this.resolution = resolution;
        this.position = position;
        this.etat = etat;
    }

    public Camera() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModeles() {
        return modeles;
    }

    public void setModeles(String modeles) {
        this.modeles = modeles;
    }

    public Double getAngleVision() {
        return angleVision;
    }

    public void setAngleVision(Double angleVision) {
        this.angleVision = angleVision;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }
}
