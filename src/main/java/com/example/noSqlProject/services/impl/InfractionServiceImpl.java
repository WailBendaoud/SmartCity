package com.example.noSqlProject.services.impl;

import com.example.noSqlProject.entities.mongo.Infraction;
import com.example.noSqlProject.entities.mongo.Radar;
import com.example.noSqlProject.entities.mongo.Vehicule;
import com.example.noSqlProject.exceptions.NotFoundException;
import com.example.noSqlProject.repositories.mongo.InfractionRepository;
import com.example.noSqlProject.repositories.mongo.RadarRepository;
import com.example.noSqlProject.repositories.mongo.VehiculeRepository;
import com.example.noSqlProject.services.api.InfractionService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class InfractionServiceImpl implements InfractionService {

    private final InfractionRepository infractionRepository;
    private final VehiculeRepository vehiculeRepository;
    private final RadarRepository radarRepository;

    private final String msgInfraction = "Infraction introuvable";
    private final String msgVehicule = "Véhicule introuvable";
    private final String msgRadar = "Radar introuvable";

    public InfractionServiceImpl(
            InfractionRepository infractionRepository,
            VehiculeRepository vehiculeRepository,
            RadarRepository radarRepository) {

        this.infractionRepository = infractionRepository;
        this.vehiculeRepository = vehiculeRepository;
        this.radarRepository = radarRepository;
    }

    @Override
    public List<Infraction> getAll() {
        return infractionRepository.findAll();
    }

    @Override
    public Infraction findById(String id) {
        return infractionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(msgInfraction));
    }

    @Override
    @Transactional
    public Infraction save(Infraction infraction) {

        Vehicule v=vehiculeRepository.findById(infraction.getVehicule().getId())
                .orElseThrow(() -> new NotFoundException(msgVehicule));


        Radar r=radarRepository.findById(infraction.getRadar().getId())
                .orElseThrow(() -> new NotFoundException(msgRadar));

        infraction.setRadar(r);
        infraction.setVehicule(v);

        infraction.setDate(LocalDateTime.now());
        Infraction save= infractionRepository.save(infraction);
        r.getInfractions().add(save.getId());
        return save;
    }

    @Override
    public Infraction update(Infraction infraction, String id) {
        return null;
    }

    @Override
    public void deleteById(String id) {
        if (!infractionRepository.existsById(id)) {
            throw new NotFoundException(msgInfraction);
        }
        infractionRepository.deleteById(id);
    }
}

