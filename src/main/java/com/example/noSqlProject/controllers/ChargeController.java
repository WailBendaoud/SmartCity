package com.example.noSqlProject.controllers;

import com.example.noSqlProject.entities.mongo.Charge;
import com.example.noSqlProject.services.api.ChargeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/charges")
public class ChargeController {

    private final ChargeService chargeService;

    public ChargeController(ChargeService chargeService) {
        this.chargeService = chargeService;
    }

    @GetMapping
    public ResponseEntity<List<Charge>> getAll() {
        return ResponseEntity.ok(chargeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Charge> findById(@PathVariable String id) {
        return ResponseEntity.ok(chargeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Charge> save(@RequestBody Charge element) {
        return new ResponseEntity<>(chargeService.save(element), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Charge> update(@RequestBody Charge element, @PathVariable String id) {
        return ResponseEntity.ok(chargeService.update(element, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        chargeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

