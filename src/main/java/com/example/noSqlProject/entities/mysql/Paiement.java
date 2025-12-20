package com.example.noSqlProject.entities.mysql;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double montant;
    private Date datePaiment;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Paiement paiement;


}
