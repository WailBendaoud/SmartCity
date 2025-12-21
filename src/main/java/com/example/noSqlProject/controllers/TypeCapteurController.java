package com.example.noSqlProject.controllers;

import com.example.noSqlProject.entities.mongo.TypeCapteur;
import com.example.noSqlProject.services.api.TypeCapteurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/typeCapteur")
public class TypeCapteurController {

    private final TypeCapteurService service;

    public TypeCapteurController(TypeCapteurService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TypeCapteur>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeCapteur> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<TypeCapteur> save(@RequestBody TypeCapteur typeCapteur) {
        return new ResponseEntity<>(service.save(typeCapteur), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeCapteur> update(
            @RequestBody TypeCapteur typeCapteur,
            @PathVariable String id) {
        return ResponseEntity.ok(service.update(typeCapteur, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.ok("TypeCapteur supprimé avec succès");
    }
}
