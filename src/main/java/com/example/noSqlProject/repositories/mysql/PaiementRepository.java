package com.example.noSqlProject.repositories.mysql;

import com.example.noSqlProject.entities.mysql.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement,Long> {
}
