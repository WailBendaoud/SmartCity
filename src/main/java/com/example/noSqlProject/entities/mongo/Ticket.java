package com.example.noSqlProject.entities.mongo;

import com.example.noSqlProject.entities.mysql.Paiement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "Ticket")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    private String id;
    private LocalDateTime heureEntre;
    private LocalDateTime heureSortie;
    private Double prix;
    private Long paiement;

}
