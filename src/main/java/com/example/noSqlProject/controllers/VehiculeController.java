package com.example.noSqlProject.controllers;

import com.example.noSqlProject.entities.mongo.Vehicule;
import com.example.noSqlProject.services.api.VehiculeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicule")
public class VehiculeController {

    private final VehiculeService vehiculeService;
    private final String msgDelete = "Véhicule supprimé avec succès";

    public VehiculeController(VehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }


    @GetMapping
    public ResponseEntity<List<Vehicule>> getAll() {
        return ResponseEntity.ok(vehiculeService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Vehicule> getById(@PathVariable String id) {
        return ResponseEntity.ok(vehiculeService.findById(id));
    }


    @PostMapping
    public ResponseEntity<Vehicule> save(@RequestBody Vehicule vehicule) {
        Vehicule saved = vehiculeService.save(vehicule);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Vehicule> update(
            @RequestBody Vehicule vehicule,
            @PathVariable String id) {

        return ResponseEntity.ok(
                vehiculeService.update(vehicule, id)
        );
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        vehiculeService.deleteById(id);
        return ResponseEntity.ok(msgDelete);
    }
    @GetMapping("/{id}/client")
    public ResponseEntity<List<Vehicule>>findByClient(@PathVariable Long id){
        return ResponseEntity.ok(vehiculeService.findByClient(id));
    }
}

