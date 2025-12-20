package com.example.noSqlProject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

//@TypeAlias("user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client extends User{
    private Date dateInscription;
    private List<Paiement>paiement;
}
