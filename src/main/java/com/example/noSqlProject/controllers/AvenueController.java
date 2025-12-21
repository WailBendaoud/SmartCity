package com.example.noSqlProject.controllers;

import com.example.noSqlProject.entities.mongo.*;
import com.example.noSqlProject.services.api.AvenueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/avenue")
public class AvenueController {

    private final AvenueService avenueService;
    private final String msgDelete = "Supprimé avec succès";

    public AvenueController(AvenueService avenueService) {
        this.avenueService = avenueService;
    }

    // 🔹 GET ALL
    @GetMapping
    public ResponseEntity<List<Avenue>> getAll() {
        return ResponseEntity.ok(avenueService.getAll());
    }

    // 🔹 GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Avenue> findById(@PathVariable String id) {
        return ResponseEntity.ok(avenueService.findById(id));
    }

    // 🔹 CREATE
    @PostMapping(consumes = "application/json")
    public ResponseEntity<Avenue> save(@RequestBody Avenue avenue) {
        Avenue saved = avenueService.save(avenue);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // 🔹 UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Avenue> update(
            @RequestBody Avenue avenue,
            @PathVariable String id) {

        return ResponseEntity.ok(avenueService.update(avenue, id));
    }

    // 🔹 DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        avenueService.deleteById(id);
        return ResponseEntity.ok(msgDelete);
    }
     //🔹 ADD CAMERAS TO AVENUE
    @PutMapping("/{id}/cameras")
    public ResponseEntity<Avenue> addCameras(
            @PathVariable("id") String idAvenue,
            @RequestBody List<Camera> cameras) {

        Avenue updatedAvenue = avenueService.addCamera(idAvenue, cameras);
        return ResponseEntity.ok(updatedAvenue);
    }

    @PutMapping("/{id}/stations")
    public ResponseEntity<Avenue> addStations(
            @PathVariable String id,
            @RequestBody List<Station> stations) {

        Avenue updated = avenueService.addStation(id, stations);
        return ResponseEntity.ok(updated);
    }

    @PutMapping("/{id}/capteurs")
    public ResponseEntity<Avenue> addCapteurs(
            @PathVariable String id,
            @RequestBody List<Capteur> capteurs) {

        Avenue updated = avenueService.addCapteure(id, capteurs);
        return ResponseEntity.ok(updated);
    }

//    @PutMapping("/{idAvenue}/parking/{idParking}")
//    public ResponseEntity<Avenue> addParking(
//            @PathVariable String idAvenue,
//            @PathVariable String idParking) {
//        Avenue updated = avenueService.addParking(idAvenue, idParking);
//        return ResponseEntity.ok(updated);
//    }

    // 🔹 Ajouter plusieurs parkings
    @PutMapping("/{idAvenue}/parkings")
    public ResponseEntity<Avenue> addParkings(
            @PathVariable String idAvenue,
            @RequestBody List<String> idParkings) {
        Avenue updated = avenueService.addParkings(idAvenue, idParkings);
        return ResponseEntity.ok(updated);
    }

    // 🔹 Ajouter plusieurs stations de bus
    @PutMapping("/{idAvenue}/stationsbus")
    public ResponseEntity<Avenue> addStationsBus(
            @PathVariable String idAvenue,
            @RequestBody List<StationBus> stationsBus) {
        Avenue updated = avenueService.addStationBus(idAvenue, stationsBus);
        return ResponseEntity.ok(updated);
    }

    // 🔹 Ajouter plusieurs feux de signalisation
    @PutMapping("/{idAvenue}/feux")
    public ResponseEntity<Avenue> addFeux(
            @PathVariable String idAvenue,
            @RequestBody List<FeuSignalisation> feux) {
        Avenue updated = avenueService.addFeu(idAvenue, feux);
        return ResponseEntity.ok(updated);
    }


}
