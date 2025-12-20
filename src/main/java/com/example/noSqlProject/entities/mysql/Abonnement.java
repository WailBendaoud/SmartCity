package com.example.noSqlProject.entities.mysql;

import com.example.noSqlProject.enumeration.EtatAbonnement;
import com.example.noSqlProject.enumeration.TypeAbonnement;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Abonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TypeAbonnement typeAbonnement;
    private Date dateDebut;
    private Date dateFin;
    private Double prix;
    @Enumerated(EnumType.STRING)
    private EtatAbonnement etatAbonnement;
    private Long parkingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;


}
