package com.example.noSqlProject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Trajet {
    @Id
    private String id;
    private String pointDepart;
    private String poitArrivee;
    private String heureDepart;
    private String heureArrivee;
    private Double distance;
    private List<String>vehicule;
}
