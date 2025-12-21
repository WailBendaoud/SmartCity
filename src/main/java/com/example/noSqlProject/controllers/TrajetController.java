package com.example.noSqlProject.controllers;

import com.example.noSqlProject.entities.mongo.Trajet;
import com.example.noSqlProject.services.api.TrajetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trajet")
public class TrajetController {

    private final TrajetService trajetService;
    private final String msgDelete = "Trajet supprimé avec succès";

    public TrajetController(TrajetService trajetService) {
        this.trajetService = trajetService;
    }


    @GetMapping
    public ResponseEntity<List<Trajet>> getAll() {
        return ResponseEntity.ok(trajetService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Trajet> getById(@PathVariable String id) {
        return ResponseEntity.ok(trajetService.findById(id));
    }


    @PostMapping
    public ResponseEntity<Trajet> save(@RequestBody Trajet trajet) {
        Trajet saved = trajetService.save(trajet);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Trajet> update(
            @RequestBody Trajet trajet,
            @PathVariable String id) {

        return ResponseEntity.ok(trajetService.update(trajet, id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        trajetService.deleteById(id);
        return ResponseEntity.ok(msgDelete);
    }
}

