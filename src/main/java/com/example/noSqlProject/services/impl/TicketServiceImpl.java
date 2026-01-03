package com.example.noSqlProject.services.impl;

import com.example.noSqlProject.entities.mongo.Parking;
import com.example.noSqlProject.entities.mongo.Ticket;
import com.example.noSqlProject.entities.mongo.Vehicule;
import com.example.noSqlProject.exceptions.NotFoundException;
import com.example.noSqlProject.repositories.mongo.ParkingRepository;
import com.example.noSqlProject.repositories.mongo.TicketRepository;
import com.example.noSqlProject.repositories.mongo.VehiculeRepository;
import com.example.noSqlProject.services.api.TicketService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final ParkingRepository parkingRepository;
    private final VehiculeRepository vehiculeRepository;
    public TicketServiceImpl(TicketRepository ticketRepository, ParkingRepository parkingRepository, VehiculeRepository vehiculeRepository) {
        this.ticketRepository = ticketRepository;
        this.parkingRepository = parkingRepository;
        this.vehiculeRepository = vehiculeRepository;
    }

    @Override
    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket findById(String s) {
        return ticketRepository.findById(s).orElseThrow(()->new NotFoundException("Ticket introuvable"));
    }

    @Override
    @Transactional
    public Ticket save(Ticket element) {
        Parking p =parkingRepository.findById(element.getP().getId()).orElseThrow(()->new NotFoundException("Parking introuvable"));
        Vehicule vehicule=vehiculeRepository.findById(element.getVehicule().getId()).orElseThrow(()->new NotFoundException("Vehicule introuvable "));
        element.setVehicule(vehicule);
        element.setHeureEntre(LocalDateTime.now());
        element.setHeureSortie(null);
        element.setP(p);
        p.getTickets().add(element.getId());
        parkingRepository.save(p);
        return ticketRepository.save(element);
    }

    @Override
    public Ticket update(Ticket element, String s) {
        return null;
    }

    @Override
    public Ticket updateSortie( String s) {
       Ticket existTicket=findById(s);
       existTicket.setHeureSortie(LocalDateTime.now());
       return ticketRepository.save(existTicket);
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public List<Ticket> findByParkingId(String parkingId) {
        return ticketRepository.findByParkingId(parkingId);
    }
}
