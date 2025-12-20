package com.example.noSqlProject.repositories.mysql;

import com.example.noSqlProject.entities.mysql.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
}
