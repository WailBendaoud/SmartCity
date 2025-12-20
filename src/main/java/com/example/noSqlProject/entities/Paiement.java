package com.example.noSqlProject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Paiement {
    @Id
    private String id;
    private Double montant;
    private Date datePaiment;
    private String idClient;
    private Abonnement abonnement;
}
