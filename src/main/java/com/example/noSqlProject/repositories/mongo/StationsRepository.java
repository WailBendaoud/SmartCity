package com.example.noSqlProject.repositories.mongo;

import com.example.noSqlProject.entities.mongo.Station;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationsRepository extends MongoRepository<Station,String> {
}
