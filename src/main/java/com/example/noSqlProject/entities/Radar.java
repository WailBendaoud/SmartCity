package com.example.noSqlProject.entities;

import com.example.noSqlProject.enumeration.TypeRadar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Radar {
    @Id
    private String id;
    private TypeRadar typeRadar;
    private Double vitesseMax;
    private String position;
    private List<String>infractions;

}
