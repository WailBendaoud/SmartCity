package com.example.noSqlProject.entities;

import com.example.noSqlProject.enumeration.Degres;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Infraction {
    @Id
    private String id;
    private Double vitesse;
    private Date date;
    private Degres degres;
    private Radar radar;
    private Vehicule vehicule;
}
