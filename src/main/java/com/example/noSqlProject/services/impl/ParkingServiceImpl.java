//package com.example.noSqlProject.services.impl;
//
//import com.example.noSqlProject.entities.*;
//import com.example.noSqlProject.exceptions.NotFoundException;
//import com.example.noSqlProject.repositories.ChargeRepository;
//import com.example.noSqlProject.repositories.GestionnaireRepository;
//import com.example.noSqlProject.repositories.ParkingRepository;
//import com.example.noSqlProject.repositories.RevenueRepository;
//import com.example.noSqlProject.services.api.ParkingService;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//@AllArgsConstructor
//public class ParkingServiceImpl implements ParkingService {
//
//    private final ParkingRepository parkingRepository;
//    private final RevenueRepository revenueRepository;
//    private final ChargeRepository chargeRepository;
//
//    private final String msgParking="Parking introuvable";
//    private final String msgRevenue="Revenue introuvable";
//    private final String msgChage="Charge introuvable";
//
//    @Override
//    public List<Parking> getAll() {
//        return parkingRepository.findAll();
//    }
//
//    @Override
//    public Parking findById(String id) {
//       return parkingRepository.findById(id).orElseThrow(()->new NotFoundException(msgParking));
//    }
//
//    @Override
//    public Parking save(Parking p) {
//        List<String>st=new ArrayList<>();
//        List<Rayon>r=new ArrayList<>();
//        p.setRevenues(st);
//        p.setTickets(st);
//        p.setCharges(st);
//        p.setAbonnement(st);
//        p.setRayons(r);
//        return parkingRepository .save(p);
//    }
//
//    @Override
//    public Parking update(Parking p, String id) {
//        Parking existant=findById(id);
//        existant.setNom(p.getNom());
//        existant.setCapacite(p.getCapacite());
//        existant.setLocalisation(p.getLocalisation());
//        existant.setPrixParHeure(p.getPrixParHeure());
//        return existant;
//    }
//
//    @Override
//    public Parking addRevenue(String idParking, String idRevenue) {
//        Parking p=findById(idParking);
//        Revenue r=revenueRepository.findById(idRevenue).orElseThrow(()->new NotFoundException(msgRevenue));
//        p.getRevenues().add(idRevenue);
//        return p;
//    }
//
//    @Override
//    public Parking addRevenues(String idParking, List<String> revenue) {
//        Parking p=findById(idParking);
//        revenue.forEach(r->{
//            Revenue re=revenueRepository.findById(r).orElseThrow(()->new NotFoundException(msgRevenue));
//        });
//        p.getRevenues().addAll(revenue);
//        return p;
//    }
//
//    @Override
//    public Parking addCharge(String idParking, String idCharge) {
//
//        return null;
//    }
//
//    @Override
//    public Parking addCharges(String idParking, List<String> revenue) {
//        return null;
//    }
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
//    @Override
//    public void deleteById(String id) {
//         Parking p= findById(id);
//         parkingRepository.deleteById(id);
//    }
//
//    @Override
//    public void delete(Parking parking) {
//        Parking p=findById(parking.getId());
//        parkingRepository.delete(p);
//    }
//
//
//}
