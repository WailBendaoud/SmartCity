package com.example.noSqlProject.repositories;

import com.example.noSqlProject.entities.Parking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends MongoRepository<Parking,String> {
}
