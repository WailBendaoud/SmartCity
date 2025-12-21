package com.example.noSqlProject.controllers;

import com.example.noSqlProject.entities.mongo.Revenue;
import com.example.noSqlProject.services.api.RevenueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/revenues")
public class RevenueController {

    private final RevenueService revenueService;
    private final String msgDelete = "Revenue supprimé avec succès";

    public RevenueController(RevenueService revenueService) {
        this.revenueService = revenueService;
    }

    @GetMapping
    public ResponseEntity<List<Revenue>> getAll() {
        return ResponseEntity.ok(revenueService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Revenue> findById(@PathVariable String id) {
        return ResponseEntity.ok(revenueService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Revenue> save(@RequestBody Revenue element) {
        return new ResponseEntity<>(revenueService.save(element), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Revenue> update(@RequestBody Revenue element, @PathVariable String id) {
        return ResponseEntity.ok(revenueService.update(element, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        revenueService.deleteById(id);
        return ResponseEntity.ok(msgDelete);
    }
}
