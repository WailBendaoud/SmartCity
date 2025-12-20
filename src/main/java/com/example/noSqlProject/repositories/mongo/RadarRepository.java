package com.example.noSqlProject.repositories.mongo;


import com.example.noSqlProject.entities.mongo.Radar;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RadarRepository extends MongoRepository<Radar,String> {
}
