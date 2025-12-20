package com.example.noSqlProject.entities.mongo;

import com.example.noSqlProject.enumeration.Etat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Capteur {
    private String position;
    private Etat etat;
    @Enumerated(EnumType.STRING)
    private TypeCapteur typeCapteur;
}
