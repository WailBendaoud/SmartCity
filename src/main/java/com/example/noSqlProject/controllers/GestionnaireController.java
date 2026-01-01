package com.example.noSqlProject.controllers;

import com.example.noSqlProject.entities.mysql.Gestionnaire;
import com.example.noSqlProject.services.api.GestionnaireService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gestionnaires")
public class GestionnaireController {

    private final GestionnaireService gestionnaireService;
    private final String msgDelete = "Gestionnaire supprimé avec succès";

    public GestionnaireController(GestionnaireService gestionnaireService) {
        this.gestionnaireService = gestionnaireService;
    }


    @PutMapping("/{id}/parking/{idParking}")
    public ResponseEntity<Gestionnaire> addParking(
            @PathVariable Long id,
            @PathVariable String idParking) {

        return ResponseEntity.ok(
                gestionnaireService.addParking(id, idParking)
        );
    }


    @GetMapping
    public ResponseEntity<List<Gestionnaire>> getAll() {
        return ResponseEntity.ok(gestionnaireService.getAll());
    }
    @GetMapping("/dispo")
    public ResponseEntity<List<Gestionnaire>> getAllParkingNull() {
        return ResponseEntity.ok(gestionnaireService.getAllParkingNull());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Gestionnaire> getById(@PathVariable Long id) {
        return ResponseEntity.ok(gestionnaireService.findById(id));
    }


    @PostMapping
    public ResponseEntity<Gestionnaire> save(@RequestBody Gestionnaire gestionnaire) {
        Gestionnaire saved = gestionnaireService.save(gestionnaire);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gestionnaire> update(
            @RequestBody Gestionnaire gestionnaire,
            @PathVariable Long id) {

        return ResponseEntity.ok(
                gestionnaireService.update(gestionnaire, id)
        );
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        gestionnaireService.deleteById(id);
        return ResponseEntity.ok(msgDelete);
    }
}
