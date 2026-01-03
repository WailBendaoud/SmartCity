package com.example.noSqlProject.services.api;

import com.example.noSqlProject.entities.mongo.Stationnement;
import com.example.noSqlProject.services.GenericService;

import java.util.List;

public interface StationnementService extends GenericService<Stationnement,String> {
    List<Stationnement> getStationnementsEnCours(String parkingId);
}
