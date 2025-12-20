package com.example.noSqlProject.repositories;

import com.example.noSqlProject.entities.Paiement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementRepository extends MongoRepository<Paiement,String> {
}
