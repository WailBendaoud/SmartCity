package com.example.noSqlProject.repositories.mysql;


import com.example.noSqlProject.entities.mysql.Abonnement;
import com.example.noSqlProject.enumeration.EtatAbonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbonnementRepository extends JpaRepository<Abonnement,Long> {
    Abonnement findByClientIdAndEtatAbonnement(Long id, EtatAbonnement t);
    List<Abonnement> findByClientIdOrderByDateDebutDesc(Long clientId);

}
