package com.example.noSqlProject.controllers;

import com.example.noSqlProject.entities.mongo.Parking;
import com.example.noSqlProject.entities.mysql.Gestionnaire;
import com.example.noSqlProject.services.api.ParkingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parking")
public class ParkingController {

    private final ParkingService parkingService;
    private final String msgDelete="Parking supprimer avec succes";

    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }


    @GetMapping
    public ResponseEntity<List<Parking>> getAll() {
        return ResponseEntity.ok(parkingService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Parking> getById(@PathVariable String id) {
        return ResponseEntity.ok(parkingService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Parking> save(@RequestBody Parking parking) {
        Parking saved = parkingService.save(parking);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Parking> update(
            @RequestBody Parking parking,
            @PathVariable String id) {

        return ResponseEntity.ok(parkingService.update(parking, id));
    }

    @PutMapping("/{id}/gestionnaire")
    public ResponseEntity<Parking> changeGestionnaire(
            @PathVariable String id,
            @RequestBody Gestionnaire gestionnaire) {

        return ResponseEntity.ok(
                parkingService.changeGestionnaire(id, gestionnaire)
        );
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        parkingService.deleteById(id);
        return new ResponseEntity(msgDelete,HttpStatus.OK);
    }
}
