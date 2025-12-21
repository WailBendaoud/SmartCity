package com.example.noSqlProject.entities.mongo;

import com.example.noSqlProject.enumeration.Etat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



public class FeuSignalisation {
    private Etat etat;
    private Integer dureeVert;
    private Integer dureeOrange;
    private Integer dureeRouge;
    private String position;

    public FeuSignalisation(Etat etat, Integer dureeVert, Integer dureeOrange, Integer dureeRouge, String  position) {
        this.etat = etat;
        this.dureeVert = dureeVert;
        this.dureeOrange = dureeOrange;
        this.dureeRouge = dureeRouge;
        this.position = position;
    }

    public FeuSignalisation() {
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public Integer getDureeVert() {
        return dureeVert;
    }

    public void setDureeVert(Integer dureeVert) {
        this.dureeVert = dureeVert;
    }

    public Integer getDureeOrange() {
        return dureeOrange;
    }

    public void setDureeOrange(Integer dureeOrange) {
        this.dureeOrange = dureeOrange;
    }

    public Integer getDureeRouge() {
        return dureeRouge;
    }

    public void setDureeRouge(Integer dureeRouge) {
        this.dureeRouge = dureeRouge;
    }

    public String  getPosition() {
        return position;
    }

    public void setPosition(String  position) {
        this.position = position;
    }
}
