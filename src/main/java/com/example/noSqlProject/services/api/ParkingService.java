package com.example.noSqlProject.services.api;

import com.example.noSqlProject.entities.Abonnement;
import com.example.noSqlProject.entities.Parking;
import com.example.noSqlProject.services.GenericService;

import java.util.List;

public interface ParkingService extends GenericService<Parking> {

    Parking addRevenue(String idParking,String idRevenue);
    Parking addRevenues(String idParking,List<String>revenue);
    Parking addCharge(String idParking,String idRevenue);
    Parking addCharges(String idParking,List<String>revenue);
    Parking addAbonnement(String idParking,Abonnement a);
    Parking addTicket(String idParking,String idTicket);



}
