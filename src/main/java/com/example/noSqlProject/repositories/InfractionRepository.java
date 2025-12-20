package com.example.noSqlProject.repositories;

import com.example.noSqlProject.entities.Infraction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfractionRepository extends MongoRepository<Infraction,String> {
}
