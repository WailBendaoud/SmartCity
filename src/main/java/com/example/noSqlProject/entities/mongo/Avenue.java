package com.example.noSqlProject.entities.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection ="Avenue")

@NoArgsConstructor
@AllArgsConstructor
public class Avenue {
    @Id
    private String id;
    private String nom;
    private Double longueur;
    private Double largeur;
    private Integer nbvoies;
    private String ville;
    private String code_postal;
    private String coordonees;
    private List<Camera> cameras;
    private List<String>radars;//
    private List<Station>stations;
    private List<String>parkings;//
    private List<Capteur>capteurs;
    private List<StationBus>stationBus;
    private List<FeuSignalisation>feuSignalisation;

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

    public Double getLongueur() {
        return longueur;
    }

    public void setLongueur(Double longueur) {
        this.longueur = longueur;
    }

    public Double getLargeur() {
        return largeur;
    }

    public void setLargeur(Double largeur) {
        this.largeur = largeur;
    }

    public Integer getNbvoies() {
        return nbvoies;
    }

    public void setNbvoies(Integer nbvoies) {
        this.nbvoies = nbvoies;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public String getCoordonees() {
        return coordonees;
    }

    public void setCoordonees(String coordonees) {
        this.coordonees = coordonees;
    }

    public List<Camera> getCameras() {
        return cameras;
    }

    public void setCameras(List<Camera> cameras) {
        this.cameras = cameras;
    }

    public List<String> getRadars() {
        return radars;
    }

    public void setRadars(List<String> radars) {
        this.radars = radars;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    public List<String> getParkings() {
        return parkings;
    }

    public void setParkings(List<String> parkings) {
        this.parkings = parkings;
    }

    public List<Capteur> getCapteurs() {
        return capteurs;
    }

    public void setCapteurs(List<Capteur> capteurs) {
        this.capteurs = capteurs;
    }

    public List<StationBus> getStationBus() {
        return stationBus;
    }

    public void setStationBus(List<StationBus> stationBus) {
        this.stationBus = stationBus;
    }

    public List<FeuSignalisation> getFeuSignalisation() {
        return feuSignalisation;
    }

    public void setFeuSignalisation(List<FeuSignalisation> feuSignalisation) {
        this.feuSignalisation = feuSignalisation;
    }
}
