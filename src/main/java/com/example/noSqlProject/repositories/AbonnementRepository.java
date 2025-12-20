package com.example.noSqlProject.repositories;

import com.example.noSqlProject.entities.Abonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbonnementRepository extends JpaRepository<Abonnement,Long> {
}
