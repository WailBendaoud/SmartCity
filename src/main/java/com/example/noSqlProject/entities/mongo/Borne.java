package com.example.noSqlProject.entities.mongo;

import com.example.noSqlProject.enumeration.EtatBorne;
import com.example.noSqlProject.enumeration.TypePrise;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Document

public class Borne {
    //@Id

    private TypePrise typePrise;
    private Double puissance;
    private EtatBorne etat;
    private String localisation;
    private Double tarifParHeure;

    public Borne(Double tarifParHeure, String localisation, EtatBorne etat, Double puissance, TypePrise typePrise) {
        this.tarifParHeure = tarifParHeure;
        this.localisation = localisation;
        this.etat = etat;
        this.puissance = puissance;
        this.typePrise = typePrise;

    }

    public Borne() {
    }

    public Double getTarifParHeure() {
        return tarifParHeure;
    }

    public void setTarifParHeure(Double tarifParHeure) {
        this.tarifParHeure = tarifParHeure;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public EtatBorne getEtat() {
        return etat;
    }

    public void setEtat(EtatBorne etat) {
        this.etat = etat;
    }

    public Double getPuissance() {
        return puissance;
    }

    public void setPuissance(Double puissance) {
        this.puissance = puissance;
    }

    public TypePrise getTypePrise() {
        return typePrise;
    }

    public void setTypePrise(TypePrise typePrise) {
        this.typePrise = typePrise;
    }


    public Borne(TypePrise typePrise, Double puissance, EtatBorne etat, String localisation, Double tarifParHeure) {
        this.typePrise = typePrise;
        this.puissance = puissance;
        this.etat = etat;
        this.localisation = localisation;
        this.tarifParHeure = tarifParHeure;
    }
}
