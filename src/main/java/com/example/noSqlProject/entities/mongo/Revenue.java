package com.example.noSqlProject.entities.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Document(collection = "Revenue")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Revenue {
    @Id
    private String id;
    private Double montantTicket;
    private Date date;
}
