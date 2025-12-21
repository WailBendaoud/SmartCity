package com.example.noSqlProject.services.impl;

import com.example.noSqlProject.entities.mongo.TypeCapteur;
import com.example.noSqlProject.exceptions.NotFoundException;
import com.example.noSqlProject.repositories.mongo.TypeCapteurRepository;
import com.example.noSqlProject.services.api.TypeCapteurService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeCapteurServiceImpl implements TypeCapteurService {

    private final TypeCapteurRepository repository;
    private final String msgNotFound = "TypeCapteur introuvable";

    public TypeCapteurServiceImpl(TypeCapteurRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TypeCapteur> getAll() {
        return repository.findAll();
    }

    @Override
    public TypeCapteur findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(msgNotFound));
    }

    @Override
    public TypeCapteur save(TypeCapteur element) {
        return repository.save(element);
    }

    @Override
    public TypeCapteur update(TypeCapteur element, String id) {
        TypeCapteur existing = findById(id);
        existing.setNom(element.getNom());
        existing.setDescription(element.getDescription());
        existing.setUnite(element.getUnite());
        return repository.save(existing);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
