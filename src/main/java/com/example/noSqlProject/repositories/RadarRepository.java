package com.example.noSqlProject.repositories;

import com.example.noSqlProject.entities.Avenue;
import com.example.noSqlProject.entities.Radar;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RadarRepository extends MongoRepository<Radar,String> {
}
