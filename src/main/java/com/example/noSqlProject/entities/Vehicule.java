package com.example.noSqlProject.entities;

import com.example.noSqlProject.enumeration.TypeVehicule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vehicule {
    @Id
    private String id;
    private String immatriculation;
    private TypeVehicule typeVehicule;
    private String marque;
    private String model;
    private String couleur;
    private Double emissionCo2;
    private Trajet trajet;
    List<Infraction>infractions;
}
