package com.example.noSqlProject.entities.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;



public class Station {


    private String nom;
    private String localisation;
    private Double prixLitreEssence;
    private Double prixLitreEssencePremium;
    private Double prixDiesel;
    private Double prixDieselPremium;
    private String heureOuverture;
    private String heureFermeture;
    private List<Borne>bornes;

    public Station(String nom, String localisation, Double prixLitreEssence, Double prixLitreEssencePremium, Double prixDiesel, Double prixDieselPremium, String heureOuverture, String heureFermeture, List<Borne> bornes) {

        this.nom = nom;
        this.localisation = localisation;
        this.prixLitreEssence = prixLitreEssence;
        this.prixLitreEssencePremium = prixLitreEssencePremium;
        this.prixDiesel = prixDiesel;
        this.prixDieselPremium = prixDieselPremium;
        this.heureOuverture = heureOuverture;
        this.heureFermeture = heureFermeture;
        this.bornes = bornes;
    }

    public Station() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public Double getPrixLitreEssence() {
        return prixLitreEssence;
    }

    public void setPrixLitreEssence(Double prixLitreEssence) {
        this.prixLitreEssence = prixLitreEssence;
    }

    public Double getPrixLitreEssencePremium() {
        return prixLitreEssencePremium;
    }

    public void setPrixLitreEssencePremium(Double prixLitreEssencePremium) {
        this.prixLitreEssencePremium = prixLitreEssencePremium;
    }

    public Double getPrixDiesel() {
        return prixDiesel;
    }

    public void setPrixDiesel(Double prixDiesel) {
        this.prixDiesel = prixDiesel;
    }

    public Double getPrixDieselPremium() {
        return prixDieselPremium;
    }

    public void setPrixDieselPremium(Double prixDieselPremium) {
        this.prixDieselPremium = prixDieselPremium;
    }

    public String getHeureOuverture() {
        return heureOuverture;
    }

    public void setHeureOuverture(String heureOuverture) {
        this.heureOuverture = heureOuverture;
    }

    public String getHeureFermeture() {
        return heureFermeture;
    }

    public void setHeureFermeture(String heureFermeture) {
        this.heureFermeture = heureFermeture;
    }

    public List<Borne> getBornes() {
        return bornes;
    }

    public void setBornes(List<Borne> bornes) {
        this.bornes = bornes;
    }
}
