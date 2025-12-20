package com.example.noSqlProject.entities.mongo;

import com.example.noSqlProject.enumeration.Etat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Camera {
    //@Id
    private String id;
    private String modeles;
    private Double angleVision;
    private String resolution;
    private String position;
    private Etat etat;
}
