package com.example.noSqlProject.services.impl;

import com.example.noSqlProject.entities.Abonnement;
import com.example.noSqlProject.entities.Parking;
import com.example.noSqlProject.exceptions.NotFoundException;
import com.example.noSqlProject.repositories.AbonnementRepository;
import com.example.noSqlProject.repositories.ParkingRepository;
import com.example.noSqlProject.services.api.AbonnementService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AbonnementServiceImpl implements AbonnementService {
    private final AbonnementRepository abonnementRepository;
    private final ParkingRepository parkingRepository;
    final String msg="Abonnement introuvable";


    public List<Abonnement>getAll(){
        return abonnementRepository.findAll();
    }

    public Abonnement findById(String id){
        return abonnementRepository.findById(id).orElseThrow(()->new NotFoundException(msg));
    }

    public Abonnement save(Abonnement a){
        Parking p=parkingRepository.findById(a.getParking().getId()).orElseThrow(()->new NotFoundException("Parking introuvable"));
        return abonnementRepository.save(a);
    }

    public Abonnement update(Abonnement a,String id){
        Abonnement existant =abonnementRepository.findById(id).orElseThrow(()->new NotFoundException(msg));
        Parking p=parkingRepository.findById(a.getParking().getId()).orElseThrow(()->new NotFoundException("Parking introuvable"));
        existant.setDateDebut(a.getDateDebut());
        existant.setPrix(a.getPrix());
        existant.setParking(a.getParking());
        existant.setEtatAbonnement(a.getEtatAbonnement());
        existant.setTypeAbonnement(a.getTypeAbonnement());
        existant.setDateFin(a.getDateFin());
        return abonnementRepository.save(existant);
    }

    public void delete(Abonnement a){
        Abonnement ab=abonnementRepository.findById(a.getId()).orElseThrow(()->new NotFoundException(msg));
        abonnementRepository.delete(ab);
    }
    public void deleteById(String id){
        Abonnement ab=abonnementRepository.findById(id).orElseThrow(()->new NotFoundException(msg));
        abonnementRepository.deleteById(id);
    }




}
