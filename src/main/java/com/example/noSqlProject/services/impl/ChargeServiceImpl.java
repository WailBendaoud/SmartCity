package com.example.noSqlProject.services.impl;

import com.example.noSqlProject.entities.mongo.Charge;
import com.example.noSqlProject.entities.mongo.Parking;
import com.example.noSqlProject.repositories.mongo.ChargeRepository;
import com.example.noSqlProject.repositories.mongo.ParkingRepository;
import com.example.noSqlProject.services.api.ChargeService;
import com.example.noSqlProject.exceptions.NotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ChargeServiceImpl implements ChargeService {

    private final ChargeRepository chargeRepository;
    private final ParkingRepository parkingRepository;
    private final String msgCharge = "Charge introuvable";
    private final String msgParking = "Parking introuvable";

    public ChargeServiceImpl(ChargeRepository chargeRepository, ParkingRepository parkingRepository) {
        this.chargeRepository = chargeRepository;
        this.parkingRepository = parkingRepository;
    }

    @Override
    public List<Charge> getAll() {
        return chargeRepository.findAll();
    }

    @Override
    public Charge findById(String id) {
        return chargeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(msgCharge));
    }

    @Override
    @Transactional
    public Charge save(Charge charge) {
        Parking parking = parkingRepository.findById(charge.getParking().getId())
                .orElseThrow(() -> new NotFoundException(msgParking));
        charge.setParking(parking);

        if (charge.getDateCharge() == null) {
            charge.setDateCharge(new Date());
        }

        Charge c= chargeRepository.save(charge);
        parking.getCharges().add(c.getId());
        parkingRepository.save(parking);
        return c;
    }

    @Override
    public Charge update(Charge charge, String id) {
        Charge existing = findById(id);
        existing.setType(charge.getType());
        existing.setMontant(charge.getMontant());
        existing.setDateCharge(charge.getDateCharge());
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
        Charge existing = findById(id);
        Parking parking = parkingRepository.findById(existing.getParking().getId())
                .orElseThrow(() -> new NotFoundException(msgParking));

        parking.getCharges().removeIf(c -> c.equals(existing.getId()));
        parkingRepository.save(parking);
        chargeRepository.delete(existing);
    }
}
