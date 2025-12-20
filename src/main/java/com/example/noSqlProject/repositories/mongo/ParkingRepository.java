package com.example.noSqlProject.repositories.mongo;

import com.example.noSqlProject.entities.mongo.Parking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends MongoRepository<Parking,String> {
}
