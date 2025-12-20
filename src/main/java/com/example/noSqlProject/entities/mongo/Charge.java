package com.example.noSqlProject.entities.mongo;

import com.example.noSqlProject.enumeration.TypeCharge;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection ="Charge")
public class Charge {
    @Id
    private String  id;
    @Enumerated(EnumType.STRING)
    private TypeCharge type;
    private Double montant;
    private Date dateCharge;
    private String description;
}
