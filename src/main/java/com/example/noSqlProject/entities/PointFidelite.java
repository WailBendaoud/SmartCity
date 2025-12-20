package com.example.noSqlProject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class PointFidelite {
    @Id
    @GeneratedValue
    private Long id;
    private Integer solde;
    private Date dateMaj;
}
