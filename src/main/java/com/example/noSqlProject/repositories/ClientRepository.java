package com.example.noSqlProject.repositories;

import com.example.noSqlProject.entities.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<Client,String> {
}
