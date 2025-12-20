package com.example.noSqlProject.entities.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Station {
    @Id
    private String id;
    private String nom;
    private String localisation;
    private Double prixLitreEssence;
    private Double prixLitreEssencePremium;
    private Double prixDiesel;
    private Double prixDieselPremium;
    private String heureOuverture;
    private String heureFermeture;
    private List<Borne>bornes;

}
