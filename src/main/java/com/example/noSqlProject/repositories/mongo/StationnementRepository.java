package com.example.noSqlProject.repositories.mongo;

import com.example.noSqlProject.entities.mongo.Stationnement;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.Instant;
import java.util.List;

public interface StationnementRepository extends MongoRepository<Stationnement,String> {

    List<Stationnement> findByCreatedAtAfter(Instant lastCheck);
    List<Stationnement> findByDateHeureSortieIsNull();
    List<Stationnement> findByParkingIdAndDateHeureSortieIsNull(String parkingId);
    boolean existsByMatriculeAndParkingIdAndDateHeureSortieIsNull(String matricule, String parkingId);
    List<Stationnement> findByParkingIdAndDateHeureSortieIsNullAndCreatedAtAfter(String parkingId, Instant lastCheck);



}
