package com.example.noSqlProject.repositories;

import com.example.noSqlProject.entities.Vehicule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculeRepository extends MongoRepository<Vehicule,String> {
}
