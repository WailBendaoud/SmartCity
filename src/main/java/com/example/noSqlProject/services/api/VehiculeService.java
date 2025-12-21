package com.example.noSqlProject.services.api;

import com.example.noSqlProject.entities.mongo.Vehicule;
import com.example.noSqlProject.services.GenericService;

import java.util.List;

public interface VehiculeService extends GenericService<Vehicule,String> {
    List<Vehicule> findByClient(Long id);

}
