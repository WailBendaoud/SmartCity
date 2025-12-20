package com.example.noSqlProject.repositories;

import com.example.noSqlProject.entities.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends MongoRepository<Ticket,String> {
}
