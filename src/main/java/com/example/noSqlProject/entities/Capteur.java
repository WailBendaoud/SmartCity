package com.example.noSqlProject.entities;

import com.example.noSqlProject.enumeration.Etat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Capteur {
    private String position;
    private Etat etat;
    private TypeCapteur typeCapteur;
}
