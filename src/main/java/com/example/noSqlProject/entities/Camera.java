package com.example.noSqlProject.entities;

import com.example.noSqlProject.enumeration.Etat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
