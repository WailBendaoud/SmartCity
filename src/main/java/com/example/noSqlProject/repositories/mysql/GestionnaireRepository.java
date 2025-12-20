package com.example.noSqlProject.repositories.mysql;

import com.example.noSqlProject.entities.mysql.Gestionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GestionnaireRepository extends JpaRepository<Gestionnaire,Long> {
}
