package com.example.noSqlProject.entities.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Document(collection ="Avenue")


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
    private Instant createdAt;

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

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Avenue() {

    }

    public Avenue(String id, String nom, Double longueur, Double largeur, Integer nbvoies, String ville, String code_postal, String coordonees, List<Camera> cameras, List<String> radars, List<Station> stations, List<String> parkings, List<Capteur> capteurs, List<StationBus> stationBus, List<FeuSignalisation> feuSignalisation, Instant createdAt) {
        this.id = id;
        this.nom = nom;
        this.longueur = longueur;
        this.largeur = largeur;
        this.nbvoies = nbvoies;
        this.ville = ville;
        this.code_postal = code_postal;
        this.coordonees = coordonees;
        this.cameras = cameras;
        this.radars = radars;
        this.stations = stations;
        this.parkings = parkings;
        this.capteurs = capteurs;
        this.stationBus = stationBus;
        this.feuSignalisation = feuSignalisation;
        this.createdAt = createdAt;
    }
}
