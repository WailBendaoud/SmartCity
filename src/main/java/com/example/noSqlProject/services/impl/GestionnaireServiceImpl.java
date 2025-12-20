package com.example.noSqlProject.services.impl;

import com.example.noSqlProject.entities.mongo.Parking;
import com.example.noSqlProject.entities.mysql.Gestionnaire;
import com.example.noSqlProject.exceptions.NotFoundException;
import com.example.noSqlProject.repositories.mongo.ParkingRepository;
import com.example.noSqlProject.repositories.mysql.GestionnaireRepository;
import com.example.noSqlProject.services.api.GestionnaireService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestionnaireServiceImpl implements GestionnaireService {

    private final GestionnaireRepository gestionnaireRepository;
    private final ParkingRepository parkingRepository;

    public GestionnaireServiceImpl(GestionnaireRepository gestionnaireRepository, ParkingRepository parkingRepository) {
        this.gestionnaireRepository = gestionnaireRepository;
        this.parkingRepository = parkingRepository;
    }
    private final String msg="Gestionnaire introuvable";

    @Override
    public List<Gestionnaire> getAll() {
        return gestionnaireRepository.findAll();
    }

    @Override
    public Gestionnaire findById(Long id) {
        return gestionnaireRepository.findById(id)
                .orElseThrow(() ->new NotFoundException(msg));}

    @Override
    public Gestionnaire save(Gestionnaire gestionnaire) {
        return gestionnaireRepository.save(gestionnaire);
    }

    @Override
    public Gestionnaire update(Gestionnaire gestionnaire, Long id) {
        Gestionnaire existing = findById(id);
        existing.setNom(gestionnaire.getNom());
        existing.setPrenom(gestionnaire.getPrenom());
        existing.setEmail(gestionnaire.getEmail());
        existing.setTelephone(gestionnaire.getTelephone());
        existing.setSalaire(gestionnaire.getSalaire());

        return gestionnaireRepository.save(existing);
    }



    @Override
    @Transactional
    public void deleteById(Long id) {
        Gestionnaire g=findById(id);
        Parking p=parkingRepository.findById(g.getParkingId()).orElseThrow(()->new NotFoundException("Parking introuvable"));
        p.setGestionnaire(null);
        gestionnaireRepository.deleteById(id);
    }

    @Override
    public Gestionnaire addParking(Long id,String idParking){
        Gestionnaire g=findById(id);
        Parking p=parkingRepository.findById(idParking).orElseThrow(()->new NotFoundException("Parking introuvable"));
        g.setParkingId(p.getId());
        return gestionnaireRepository.save(g);
    }
}
