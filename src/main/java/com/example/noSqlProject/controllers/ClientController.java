package com.example.noSqlProject.controllers;

import com.example.noSqlProject.entities.mysql.Client;
import com.example.noSqlProject.services.api.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    private final ClientService clientService;
    private final String msgDelete="Client supprimé avec succès";

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAll() {
        return ResponseEntity.ok(clientService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.findById(id));
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Client> save(@RequestBody Client client) {
        Client saved = clientService.save(client); // 🔹 Utiliser le service
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@RequestBody Client client, @PathVariable Long id) {
        return ResponseEntity.ok(clientService.update(client, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        clientService.deleteById(id);
        return ResponseEntity.ok(msgDelete);
    }
}
