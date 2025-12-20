package com.example.noSqlProject.entities.mongo;

import com.example.noSqlProject.enumeration.EtatBorne;
import com.example.noSqlProject.enumeration.TypePrise;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Borne {
    //@Id
    private String id;
    private TypePrise typePrise;
    private Double puissance;
    private EtatBorne etat;
    private String localisation;
    private Double tarifParHeure;
}
