package com.example.noSqlProject.services.impl;


import com.example.noSqlProject.entities.mysql.Abonnement;

import com.example.noSqlProject.repositories.mysql.AbonnementRepository;
import com.example.noSqlProject.repositories.mongo.ParkingRepository;
import com.example.noSqlProject.services.api.AbonnementService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbonnementServiceImpl implements AbonnementService {
    private final AbonnementRepository abonnementRepository;
    private final ParkingRepository parkingRepository;
    final String msg="Abonnement introuvable";

    public AbonnementServiceImpl(AbonnementRepository abonnementRepository, ParkingRepository parkingRepository) {
        this.abonnementRepository = abonnementRepository;
        this.parkingRepository = parkingRepository;
    }


    @Override
    public List<Abonnement> getAll() {
        return List.of();
    }

    @Override
    public Abonnement findById(Long aLong) {
        return null;
    }

    @Override
    public Abonnement save(Abonnement element) {
        return null;
    }

    @Override
    public Abonnement update(Abonnement element, Long aLong) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }


    public List<Abonnement> getHistoriqueAbonnements(Long clientId) {
        return abonnementRepository.findByClientIdOrderByDateDebutDesc(clientId);
    }
}
