package com.example.noSqlProject.entities;

import com.example.noSqlProject.services.api.AvenueService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Calendar;
import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parking {
    @Id
    private String id;
    private String nom;
    private Integer capacite;
    private String localisation;
    private Double prixParHeure;
    private Gestionnaire gestionnaire;
    private List<Rayon>rayons;//
    private List<String>abonnement;
    private List<String>tickets;//
    private List<String> revenues;//
    private List<String> charges;//
    private Avenue avenue;


}
