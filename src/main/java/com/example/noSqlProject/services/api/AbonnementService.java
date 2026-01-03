package com.example.noSqlProject.services.api;

import com.example.noSqlProject.entities.mysql.Abonnement;
import com.example.noSqlProject.services.GenericService;

import java.util.List;

public interface AbonnementService extends GenericService<Abonnement,Long> {

    List<Abonnement> getHistoriqueAbonnements(Long clientId);

}
