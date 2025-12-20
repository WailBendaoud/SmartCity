package com.example.noSqlProject.repositories;


import com.example.noSqlProject.entities.Gestionnaire;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GestionnaireRepository extends MongoRepository<Gestionnaire,String> {
}
