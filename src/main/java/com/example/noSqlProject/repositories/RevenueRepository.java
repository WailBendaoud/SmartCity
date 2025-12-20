package com.example.noSqlProject.repositories;

import com.example.noSqlProject.entities.Revenue;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevenueRepository extends MongoRepository<Revenue,String> {
}
