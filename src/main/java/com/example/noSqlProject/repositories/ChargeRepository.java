package com.example.noSqlProject.repositories;

import com.example.noSqlProject.entities.Charge;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargeRepository extends MongoRepository<Charge,String> {
}
