package com.example.noSqlProject.services.impl;


import com.example.noSqlProject.entities.mongo.*;
import com.example.noSqlProject.entities.mysql.Gestionnaire;
import com.example.noSqlProject.exceptions.NotFoundException;

import com.example.noSqlProject.repositories.mongo.AvenueRepository;
import com.example.noSqlProject.repositories.mongo.ChargeRepository;
import com.example.noSqlProject.repositories.mongo.ParkingRepository;
import com.example.noSqlProject.repositories.mongo.RevenueRepository;
import com.example.noSqlProject.repositories.mysql.GestionnaireRepository;
import com.example.noSqlProject.services.api.ParkingService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class ParkingServiceImpl implements ParkingService {
//
    private final ParkingRepository parkingRepository;
    private final RevenueRepository revenueRepository;
    private final ChargeRepository chargeRepository;
    private final AvenueRepository avenueRepository;
    private final GestionnaireRepository gestionnaireRepository;

    private final String msgParking="Parking introuvable";
    private final String msgRevenue="Revenue introuvable";
    private final String msgChage="Charge introuvable";
    private final String msgGestionnaire="Gestionnaire introuvable";

    public ParkingServiceImpl(ParkingRepository parkingRepository, RevenueRepository revenueRepository, ChargeRepository chargeRepository, AvenueRepository avenueRepository, GestionnaireRepository gestionnaireRepository) {
        this.parkingRepository = parkingRepository;
        this.revenueRepository = revenueRepository;
        this.chargeRepository = chargeRepository;
        this.avenueRepository = avenueRepository;
        this.gestionnaireRepository = gestionnaireRepository;
    }

    //
    @Override
    public List<Parking> getAll() {
        return parkingRepository.findAll();
    }

    @Override
    public Parking findById(String id) {
       return parkingRepository.findById(id).orElseThrow(()->new NotFoundException(msgParking));
    }

    @Override
    @Transactional
    public Parking save(Parking p) {
        Avenue a=avenueRepository.findById(p.getAvenue().getId()).orElseThrow(()->new NotFoundException("Avenue innexistante"));
        Gestionnaire g=gestionnaireRepository.findById(p.getGestionnaire().getId()).orElseThrow(()->new NotFoundException(msgGestionnaire));
        List<String>st=new ArrayList<>();
        List<Long>abo=new ArrayList<>();

        p.setRevenues(st);
        p.setTickets(st);
        p.setCharges(st);
        p.setAbonnement(abo);
        p.setAvenue(a);
        p.setGestionnaire(g);
        p.setLocalisation(a.getNom());
        p.setCapacite(0);
        var parkingSave= parkingRepository .save(p);
        g.setParkingId(parkingSave.getId());
        gestionnaireRepository.save(g);
        a.getParkings().add(parkingSave.getId());
        avenueRepository.save(a);
        return parkingSave;
    }

    @Override
    public Parking update(Parking p, String id) {
        Parking existant=findById(id);
        existant.setNom(p.getNom());
        existant.setCapacite(p.getCapacite());
        existant.setPrixParHeure(p.getPrixParHeure());
        return parkingRepository.save(existant);
    }
    @Override
    @Transactional
    public Parking changeGestionnaire(String id,Gestionnaire g){
        Gestionnaire gestionnaire=gestionnaireRepository.findById(g.getId()).orElseThrow(()->new NotFoundException(msgGestionnaire));
        Parking existant=findById(id);
        gestionnaire.setParkingId(id);
        existant.setGestionnaire(g);
        return parkingRepository.save(existant);
    }

    @Override
    public Parking addRayon(String parkingId, List<Rayon> rayons) {

        Parking p = findById(parkingId);

        if (p.getRayons() == null) {
            p.setRayons(new ArrayList<>());
        }

        p.getRayons().addAll(rayons);

        int sommeCapacites = rayons.stream()
                .mapToInt(Rayon::getCapacite)
                .sum();

        p.setCapacite(p.getCapacite() + sommeCapacites);

        return parkingRepository.save(p);
    }


    //
    @Override
    public Parking addRevenue(String idParking, String idRevenue) {
        Parking p=findById(idParking);
        Revenue r=revenueRepository.findById(idRevenue).orElseThrow(()->new NotFoundException(msgRevenue));
        p.getRevenues().add(idRevenue);
        return p;
    }
//
    @Override
    public Parking addRevenues(String idParking, List<String> revenue) {
        Parking p=findById(idParking);
        revenue.forEach(r->{
            Revenue re=revenueRepository.findById(r).orElseThrow(()->new NotFoundException(msgRevenue));
        });
        p.getRevenues().addAll(revenue);
        return p;
    }
//
    @Override
    public Parking addCharge(String idParking, String idCharge) {
        Parking p=findById(idParking);
        Charge r=chargeRepository.findById(idCharge).orElseThrow(()->new NotFoundException(msgRevenue));
        p.getRevenues().add(idCharge);
        return p;
    }
//
    @Override
    public Parking addCharges(String idParking, List<String> charge) {
        Parking p=findById(idParking);
        charge.forEach(r->{
            Charge re=chargeRepository.findById(r).orElseThrow(()->new NotFoundException(msgRevenue));
        });
        p.getRevenues().addAll(charge);
        return p;
    }
//
//    @Override
//    public Parking addAbonnement(String idParking, Abonnement a) {
//        return null;
//    }
//
//    @Override
//    public Parking addTicket(String idParking, String idTicket) {
//        return null;
//    }
//
//
    @Override
    @Transactional
    public void deleteById(String id) {

         Parking p= findById(id);
         Gestionnaire g =gestionnaireRepository.findById(p.getGestionnaire().getId()).orElseThrow(()->new NotFoundException("Gestionnaire introuvable"));
         g.setParkingId(null);
         parkingRepository.deleteById(id);
    }

//
//
}
