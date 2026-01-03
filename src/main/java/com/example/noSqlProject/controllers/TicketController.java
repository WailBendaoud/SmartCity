package com.example.noSqlProject.controllers;

import com.example.noSqlProject.entities.mongo.Ticket;
import com.example.noSqlProject.services.api.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    // 🔹 Récupérer tous les tickets
    @GetMapping("/all")
    public ResponseEntity<List<Ticket>> getAll() {
        List<Ticket> tickets = ticketService.getAll();
        return ResponseEntity.ok(tickets);
    }

    // 🔹 Récupérer un ticket par ID
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> findById(@PathVariable String id) {
        Ticket ticket = ticketService.findById(id);
        return ResponseEntity.ok(ticket);
    }

    // 🔹 Récupérer les tickets d'un parking spécifique
    @GetMapping("/parking/{parkingId}")
    public ResponseEntity<List<Ticket>> findByParkingId(@PathVariable String parkingId) {
        List<Ticket> tickets = ticketService.findByParkingId(parkingId);
        return ResponseEntity.ok(tickets);
    }

    // 🔹 Créer un ticket
    @PostMapping("/create")
    public ResponseEntity<Ticket> save(@RequestBody Ticket ticket) {
        Ticket savedTicket = ticketService.save(ticket);
        return ResponseEntity.ok(savedTicket);
    }

    // 🔹 Mettre à jour un ticket complet
    @PutMapping("/update/{id}")
    public ResponseEntity<Ticket> update(@RequestBody Ticket ticket, @PathVariable String id) {
        Ticket updatedTicket = ticketService.update(ticket, id);
        return ResponseEntity.ok(updatedTicket);
    }

    // 🔹 Mettre à jour uniquement la sortie d'un ticket
    @PatchMapping("/sortie/{id}")
    public ResponseEntity<Ticket> updateSortie(@PathVariable String id) {
        Ticket updatedTicket = ticketService.updateSortie(id);
        return ResponseEntity.ok(updatedTicket);
    }

    // 🔹 Supprimer un ticket
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        ticketService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
