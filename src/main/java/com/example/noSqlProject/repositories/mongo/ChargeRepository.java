package com.example.noSqlProject.repositories.mongo;

import com.example.noSqlProject.entities.mongo.Charge;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargeRepository extends MongoRepository<Charge,String> {
}
