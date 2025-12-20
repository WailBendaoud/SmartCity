package com.example.noSqlProject.repositories.mongo;

import com.example.noSqlProject.entities.mongo.Infraction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfractionRepository extends MongoRepository<Infraction,String> {
}
