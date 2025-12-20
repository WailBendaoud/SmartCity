package com.example.noSqlProject.entities.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "TypeCapteur")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TypeCapteur {
    @Id
    private String id;
    private String nom;
    private String description;
    private String unite;
}
