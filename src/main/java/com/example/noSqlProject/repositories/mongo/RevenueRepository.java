package com.example.noSqlProject.repositories.mongo;

import com.example.noSqlProject.entities.mongo.Revenue;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevenueRepository extends MongoRepository<Revenue,String> {
}
