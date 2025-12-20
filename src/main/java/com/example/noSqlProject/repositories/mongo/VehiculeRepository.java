package com.example.noSqlProject.repositories.mongo;

import com.example.noSqlProject.entities.mongo.Vehicule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculeRepository extends MongoRepository<Vehicule,String> {
}
