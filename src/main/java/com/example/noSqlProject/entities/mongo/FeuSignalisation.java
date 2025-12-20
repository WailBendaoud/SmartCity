package com.example.noSqlProject.entities.mongo;

import com.example.noSqlProject.enumeration.Etat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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
