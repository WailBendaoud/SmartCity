package com.example.noSqlProject.controllers;

import com.example.noSqlProject.entities.mongo.Radar;
import com.example.noSqlProject.services.api.RadarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/radars")
public class RadarController {

    private final RadarService radarService;
    private final String msgDelete = "Radar supprimé avec succès";

    public RadarController(RadarService radarService) {
        this.radarService = radarService;
    }

    @GetMapping
    public ResponseEntity<List<Radar>> getAll() {
        return ResponseEntity.ok(radarService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Radar> getById(@PathVariable String id) {
        return ResponseEntity.ok(radarService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Radar> save(@RequestBody Radar radar) {
        return new ResponseEntity<>(
                radarService.save(radar),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Radar> update(
            @RequestBody Radar radar,
            @PathVariable String id) {

        return ResponseEntity.ok(
                radarService.update(radar, id)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        radarService.deleteById(id);
        return ResponseEntity.ok(msgDelete);
    }
}

