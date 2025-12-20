package com.example.noSqlProject.repositories.mongo;

import com.example.noSqlProject.entities.mongo.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends MongoRepository<Ticket,String> {
}
