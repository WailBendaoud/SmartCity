package com.example.noSqlProject.repositories.mongo;

import com.example.noSqlProject.entities.mongo.Revenue;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface RevenueRepository extends MongoRepository<Revenue,String> {

    List<Revenue> findByCreatedAtAfter(Instant lastCheck);
    List<Revenue> findByParkingIdAndCreatedAtAfter(String parkingId, Instant createdAt);

}
