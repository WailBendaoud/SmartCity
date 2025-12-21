package com.example.noSqlProject.repositories.mongo;

import com.example.noSqlProject.entities.mongo.Trajet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrajetRepository extends MongoRepository<Trajet,String> {
}
