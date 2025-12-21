package com.example.noSqlProject.services.impl;

import com.example.noSqlProject.entities.mongo.Avenue;
import com.example.noSqlProject.entities.mongo.Radar;
import com.example.noSqlProject.exceptions.NotFoundException;
import com.example.noSqlProject.repositories.mongo.AvenueRepository;
import com.example.noSqlProject.repositories.mongo.RadarRepository;
import com.example.noSqlProject.services.api.RadarService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RadarServiceImpl implements RadarService {

    private final RadarRepository radarRepository;
    private final AvenueRepository avenueRepository;
    private final String msgRadar = "Radar introuvable";
    private final String msgAvenue="Avenue introuvable";

    public RadarServiceImpl(RadarRepository radarRepository, AvenueRepository avenueRepository) {
        this.radarRepository = radarRepository;
        this.avenueRepository = avenueRepository;
    }

    @Override
    public List<Radar> getAll() {
        return radarRepository.findAll();
    }

    @Override
    public Radar findById(String id) {
        return radarRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(msgRadar));
    }

    @Override
    public Radar save(Radar radar) {
        Avenue a=avenueRepository.findById(radar.getAvenue().getId()).orElseThrow(()->new NotFoundException(msgAvenue));
         radar.setAvenue(a);
        if (radar.getInfractions() == null) {
            radar.setInfractions(new ArrayList<>());
        }

        Radar saveRadar= radarRepository.save(radar);
        a.getRadars().add(saveRadar.getId());
        avenueRepository.save(a);
        return saveRadar;
    }

    @Override
    public Radar update(Radar radar, String id) {

        Radar existing = findById(id);
        existing.setTypeRadar(radar.getTypeRadar());
        existing.setVitesseMax(radar.getVitesseMax());
        existing.setPosition(radar.getPosition());
        return radarRepository.save(existing);
    }

    @Override
    public void deleteById(String id) {
        if (!radarRepository.existsById(id)) {
            throw new NotFoundException(msgRadar);
        }
        radarRepository.deleteById(id);
    }
}

