package com.example.noSqlProject.entities;

import com.example.noSqlProject.enumeration.EtatAbonnement;
import com.example.noSqlProject.enumeration.TypeAbonnement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.awt.dnd.DropTarget;
import java.util.Date;
@Document
@Data@AllArgsConstructor@NoArgsConstructor
public class Abonnement {
    @Id
    private String id;
    private TypeAbonnement typeAbonnement;
    private Date dateDebut;
    private Date dateFin;
    private Double prix;
    private EtatAbonnement etatAbonnement;
    private Parking parking;
}
