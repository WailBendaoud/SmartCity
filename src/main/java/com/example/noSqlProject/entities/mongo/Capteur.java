package com.example.noSqlProject.entities.mongo;

import com.example.noSqlProject.enumeration.Etat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Capteur {
    private String position;
    private Etat etat;
    @Enumerated(EnumType.STRING)
    private TypeCapteur typeCapteur;

    public Capteur(String position, Etat etat, TypeCapteur typeCapteur) {
        this.position = position;
        this.etat = etat;
        this.typeCapteur = typeCapteur;
    }

    public Capteur() {
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

    public TypeCapteur getTypeCapteur() {
        return typeCapteur;
    }

    public void setTypeCapteur(TypeCapteur typeCapteur) {
        this.typeCapteur = typeCapteur;
    }
}
