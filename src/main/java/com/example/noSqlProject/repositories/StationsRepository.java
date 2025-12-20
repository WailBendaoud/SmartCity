package com.example.noSqlProject.repositories;

import com.example.noSqlProject.entities.Station;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationsRepository extends MongoRepository<Station,String> {
}
