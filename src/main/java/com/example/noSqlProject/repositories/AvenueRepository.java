package com.example.noSqlProject.repositories;

import com.example.noSqlProject.entities.Avenue;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvenueRepository extends MongoRepository<Avenue,String> {
}
