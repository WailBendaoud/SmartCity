package com.example.noSqlProject.entities;

import com.example.noSqlProject.enumeration.TypeCharge;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Charge {
    @Id
    private String  id;
    private TypeCharge type;
    private Double montant;
    private Date dateCharge;
    private String description;
}
