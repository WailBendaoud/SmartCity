package com.example.noSqlProject.repositories.mongo;

import com.example.noSqlProject.entities.mongo.Revenue;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RevenuRepository extends MongoRepository<Revenue,String> {
}
