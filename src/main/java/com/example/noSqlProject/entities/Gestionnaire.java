package com.example.noSqlProject.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gestionnaire extends User{
    private Double salaire;
    private Date dateEmboche;
    private Long parkingId;
}

