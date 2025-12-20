package com.example.noSqlProject.entities;

import com.example.noSqlProject.enumeration.EtatBorne;
import com.example.noSqlProject.enumeration.TypePrise;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
