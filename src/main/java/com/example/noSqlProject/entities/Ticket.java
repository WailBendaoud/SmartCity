package com.example.noSqlProject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;
@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    private String id;
    private LocalDateTime heureEntre;
    private LocalDateTime heureSortie;
    private Double prix;
    private Paiement paiement;

}
