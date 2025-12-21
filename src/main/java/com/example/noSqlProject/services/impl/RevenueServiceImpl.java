package com.example.noSqlProject.services.impl;

import com.example.noSqlProject.entities.mongo.Charge;
import com.example.noSqlProject.entities.mongo.Parking;
import com.example.noSqlProject.entities.mongo.Revenue;
import com.example.noSqlProject.exceptions.NotFoundException;
import com.example.noSqlProject.repositories.mongo.ChargeRepository;
import com.example.noSqlProject.repositories.mongo.ParkingRepository;
import com.example.noSqlProject.repositories.mongo.RevenueRepository;
import com.example.noSqlProject.services.api.RevenueService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class RevenueServiceImpl implements RevenueService {
    private final RevenueRepository chargeRepository;
    private final ParkingRepository parkingRepository;
    private final String msgCharge = "Charge introuvable";
    private final String msgParking = "Parking introuvable";

    public RevenueServiceImpl(RevenueRepository chargeRepository, ParkingRepository parkingRepository) {
        this.chargeRepository = chargeRepository;
        this.parkingRepository = parkingRepository;
    }

    @Override
    public List<Revenue> getAll() {
        return chargeRepository.findAll();
    }

    @Override
    public Revenue findById(String id) {
        return chargeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(msgCharge));
    }

    @Override
    @Transactional
    public Revenue save(Revenue charge) {
        Parking parking = parkingRepository.findById(charge.getParking().getId())
                .orElseThrow(() -> new NotFoundException(msgParking));
        charge.setParking(parking);

        if (charge.getDateRevenu() == null) {
            charge.setDateRevenu(new Date());
        }

        Revenue c= chargeRepository.save(charge);
        parking.getRevenues().add(c.getId());
        parkingRepository.save(parking);
        return c;
    }

    @Override
    public Revenue update(Revenue charge, String id) {
        Revenue existing = findById(id);
        existing.setType(charge.getType());
        existing.setMontant(charge.getMontant());
        existing.setDateRevenu(charge.getDateRevenu());
        existing.setDescription(charge.getDescription());

        if (charge.getParking() != null) {
            Parking parking = parkingRepository.findById(charge.getParking().getId())
                    .orElseThrow(() -> new NotFoundException(msgParking));
            existing.setParking(parking);
        }

        return chargeRepository.save(existing);
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        Revenue existing = findById(id);
        Parking parking = parkingRepository.findById(existing.getParking().getId())
                .orElseThrow(() -> new NotFoundException(msgParking));

        parking.getRevenues().removeIf(c -> c.equals(existing.getId()));
        parkingRepository.save(parking);
        chargeRepository.delete(existing);
    }
}
