package com.example.noSqlProject.entities;

import com.example.noSqlProject.enumeration.Etat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeuSignalisation {
    private Etat etat;
    private Integer dureeVert;
    private Integer dureeOrange;
    private Integer dureeRouge;
    private String position;

}
