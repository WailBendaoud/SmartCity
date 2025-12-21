package com.example.noSqlProject.services.impl;

import com.example.noSqlProject.entities.mongo.Trajet;
import com.example.noSqlProject.entities.mongo.Vehicule;
import com.example.noSqlProject.exceptions.NotFoundException;
import com.example.noSqlProject.repositories.mongo.TrajetRepository;
import com.example.noSqlProject.repositories.mongo.VehiculeRepository;
import com.example.noSqlProject.services.api.TrajetService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrajetServiceImpl implements TrajetService {

    private final TrajetRepository trajetRepository;
    private final VehiculeRepository vehiculeRepository;
    private final String msgTrajet="Trajet introuvable";
    private final String msgVehicule="Vehicule introuvable";

    public TrajetServiceImpl(TrajetRepository trajetRepository, VehiculeRepository vehiculeRepository) {
        this.trajetRepository = trajetRepository;
        this.vehiculeRepository = vehiculeRepository;
    }

    @Override
    public List<Trajet> getAll() {
        return trajetRepository.findAll();
    }

    @Override
    public Trajet findById(String s) {
        return trajetRepository.findById(s).orElseThrow(()->new NotFoundException(msgTrajet));
    }

    @Override
    @Transactional
    public Trajet save(Trajet element) {
        Vehicule v=vehiculeRepository.findById(element.getVehicule().getId()).orElseThrow(()->new NotFoundException(msgVehicule));
        element.setVehicule(v);
        Trajet trajet=trajetRepository.save(element);
        v.getTrajet().add(trajet.getId());
        return trajet;
    }

    @Override
    public Trajet update(Trajet trajet, String id) {

        Trajet existing = trajetRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException(msgTrajet)
                );

        existing.setPointDepart(trajet.getPointDepart());
        existing.setPoitArrivee(trajet.getPoitArrivee());
        existing.setHeureDepart(trajet.getHeureDepart());
        existing.setHeureArrivee(trajet.getHeureArrivee());
        existing.setDistance(trajet.getDistance());

        return trajetRepository.save(existing);
    }


    @Override
    public void deleteById(String s) {
          Trajet t=findById(s);
          trajetRepository.deleteById(s);
    }
}
