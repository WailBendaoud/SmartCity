package com.example.noSqlProject.repositories.mongo;


import com.example.noSqlProject.entities.mysql.Abonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbonnementRepository extends JpaRepository<Abonnement,Long> {
}
