package com.example.noSqlProject.controllers;

import com.example.noSqlProject.entities.mongo.Stationnement;
import com.example.noSqlProject.services.api.StationnementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stationnement")
public class StationnementController {

    private final StationnementService stationnementService;

    public StationnementController(StationnementService stationnementService) {
        this.stationnementService = stationnementService;
    }

    // ✅ Stationnements en cours pour un parking
    @GetMapping("/en-cours/{parkingId}")
    public ResponseEntity<List<Stationnement>> getStationnementsEnCours(@PathVariable String parkingId) {
        List<Stationnement> enCours = stationnementService.getStationnementsEnCours(parkingId);
        return ResponseEntity.ok(enCours);
    }

    // ✅ Tous les stationnements
    @GetMapping
    public ResponseEntity<List<Stationnement>> getAll() {
        List<Stationnement> all = stationnementService.getAll();
        return ResponseEntity.ok(all);
    }

    // ✅ Stationnement par id
    @GetMapping("/{id}")
    public ResponseEntity<Stationnement> findById(@PathVariable String id) {
        return ResponseEntity.ok(stationnementService.findById(id)); // 404 si inexistant
    }

    // ✅ Création d’un stationnement
    @PostMapping
    public ResponseEntity<Stationnement> save(@RequestBody Stationnement element) {
        Stationnement saved = stationnementService.save(element);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved); // 201 Created
    }

    // ✅ Mise à jour
    @PutMapping("/{id}")
    public ResponseEntity<Stationnement> update(@RequestBody Stationnement element, @PathVariable String id) {
        return ResponseEntity.ok(stationnementService.update(element, id));
    }

    // ✅ Suppression
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        stationnementService.deleteById(id);
        return new ResponseEntity<>("Supprimer avec succes",HttpStatus.OK);

    }}
