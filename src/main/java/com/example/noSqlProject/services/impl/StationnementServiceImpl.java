package com.example.noSqlProject.services.impl;

import com.example.noSqlProject.entities.mongo.Parking;
import com.example.noSqlProject.entities.mongo.Stationnement;
import com.example.noSqlProject.exceptions.NotFoundException;
import com.example.noSqlProject.repositories.mongo.ParkingRepository;
import com.example.noSqlProject.repositories.mongo.StationnementRepository;
import com.example.noSqlProject.services.api.StationnementService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@Service
public class StationnementServiceImpl implements StationnementService {

    private final StationnementRepository stationnementRepository;
    private final ParkingRepository parkingRepository;

    public StationnementServiceImpl(StationnementRepository stationnementRepository, ParkingRepository parkingRepository) {
        this.stationnementRepository = stationnementRepository;
        this.parkingRepository = parkingRepository;
    }

    @Override
    public List<Stationnement> getAll() {
        return stationnementRepository.findAll();
    }

    @Override
    public Stationnement findById(String s) {
        return stationnementRepository.findById(s).orElseThrow(()->new NotFoundException("Introuvable"));
    }

    @Override
    public Stationnement save(Stationnement element) {
        Parking p = parkingRepository.findById(element.getParking().getId())
                .orElseThrow(() -> new NotFoundException("Parking introuvable"));

        // 🔹 Vérifier si la voiture est déjà dans ce parking
        boolean existe = stationnementRepository
                .existsByMatriculeAndParkingIdAndDateHeureSortieIsNull(element.getMatricule(), p.getId());

        if (existe) {
            throw new IllegalArgumentException(
                    "La voiture avec le matricule " + element.getMatricule() + " est déjà en stationnement dans ce parking"
            );
        }

        // 🔹 Remplir les champs
        element.setDateHeureEntre(LocalDateTime.now());
        element.setDateHeureSortie(null);
        element.setParking(p);

        return stationnementRepository.save(element);
    }


    @Override
    public Stationnement update(Stationnement element, String s) {
        Stationnement st=findById(s);
        st.setDateHeureSortie(LocalDateTime.now());
        return stationnementRepository.save(st);
    }

    @Override
    public void deleteById(String s) {

    }
    public List<Stationnement> getStationnementsEnCours(String parkingId) {
        return stationnementRepository
                .findByParkingIdAndDateHeureSortieIsNull(parkingId);
    }
}
