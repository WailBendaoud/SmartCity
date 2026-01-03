package com.example.noSqlProject.services.api;

import com.example.noSqlProject.entities.mongo.Ticket;
import com.example.noSqlProject.repositories.mongo.TicketRepository;
import com.example.noSqlProject.services.GenericService;

import java.util.List;

public interface TicketService extends GenericService<Ticket,String> {
    List<Ticket>findByParkingId(String parkingId);
    Ticket updateSortie( String s);
}
