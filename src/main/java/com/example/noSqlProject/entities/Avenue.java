package com.example.noSqlProject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
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
}
