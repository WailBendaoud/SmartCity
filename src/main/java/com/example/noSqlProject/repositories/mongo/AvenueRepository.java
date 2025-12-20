package com.example.noSqlProject.repositories.mongo;


import com.example.noSqlProject.entities.mongo.Avenue;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvenueRepository extends MongoRepository<Avenue,String> {
}
