package com.example.noSqlProject.controllers;

import com.example.noSqlProject.entities.mongo.Infraction;
import com.example.noSqlProject.services.api.InfractionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/infractions")
public class InfractionController {

    private final InfractionService infractionService;
    private final String msgDelete = "Infraction supprimée avec succès";

    public InfractionController(InfractionService infractionService) {
        this.infractionService = infractionService;
    }

    @GetMapping
    public ResponseEntity<List<Infraction>> getAll() {
        return ResponseEntity.ok(infractionService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Infraction> getById(@PathVariable String id) {
        return ResponseEntity.ok(infractionService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Infraction> save(@RequestBody Infraction infraction) {
        return new ResponseEntity<>(
                infractionService.save(infraction),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Infraction> update(
            @RequestBody Infraction infraction,
            @PathVariable String id) {

        return ResponseEntity.ok(
                infractionService.update(infraction, id)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        infractionService.deleteById(id);
        return ResponseEntity.ok(msgDelete);
    }
}

