package com.example.noSqlProject.entities;

import com.example.noSqlProject.enumeration.EtatAbonnement;
import com.example.noSqlProject.enumeration.TypeAbonnement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.awt.dnd.DropTarget;
import java.util.Date;
@Entity
@Data@AllArgsConstructor@NoArgsConstructor
public class Abonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TypeAbonnement typeAbonnement;
    private Date dateDebut;
    private Date dateFin;
    private Double prix;
    private EtatAbonnement etatAbonnement;
    private Long parkingId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;


}
