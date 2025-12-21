package com.example.noSqlProject.repositories.mongo;

import com.example.noSqlProject.entities.mongo.Vehicule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculeRepository extends MongoRepository<Vehicule,String> {
    List<Vehicule> findByClient(Long id);
}
