package com.example.noSqlProject.services.impl;

import com.example.noSqlProject.entities.mongo.Vehicule;
import com.example.noSqlProject.entities.mysql.Client;
import com.example.noSqlProject.exceptions.NotFoundException;
import com.example.noSqlProject.repositories.mongo.VehiculeRepository;
import com.example.noSqlProject.repositories.mysql.ClientRepository;
import com.example.noSqlProject.services.api.VehiculeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class VehiculeSericeImpl implements VehiculeService {

    private final VehiculeRepository vehiculeRepository;
    private final ClientRepository clientRepository;
    private final String msgVehicule = "Véhicule introuvable";
    private final String msgClient = "Client introuvable";


    public VehiculeSericeImpl(VehiculeRepository vehiculeRepository, ClientRepository clientRepository) {
        this.vehiculeRepository = vehiculeRepository;
        this.clientRepository = clientRepository;
    }


    @Override
    public List<Vehicule> getAll() {
        return vehiculeRepository.findAll();
    }


    @Override
    public Vehicule findById(String id) {
        return vehiculeRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException(msgVehicule + " avec id : " + id)
                );
    }


    @Override
    public Vehicule save(Vehicule vehicule) {
        Client c=clientRepository.findById(vehicule.getClient()).orElseThrow(()->new NotFoundException(msgClient));
        List<Vehicule>v=findByClient(c.getId());
        vehicule.setClient(c.getId());
        if (vehicule.getTrajet() == null) {
            vehicule.setTrajet(new ArrayList<>());
        }
        if (vehicule.getInfractions() == null) {
            vehicule.setInfractions(new ArrayList<>());
        }

        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule update(Vehicule vehicule, String id) {

        Vehicule existing = findById(id);
        existing.setImmatriculation(vehicule.getImmatriculation());
        existing.setTypeVehicule(vehicule.getTypeVehicule());
        existing.setMarque(vehicule.getMarque());
        existing.setModel(vehicule.getModel());
        existing.setCouleur(vehicule.getCouleur());
        existing.setEmissionCo2(vehicule.getEmissionCo2());
        return vehiculeRepository.save(existing);
    }

    @Override
    public void deleteById(String id) {
        if (!vehiculeRepository.existsById(id)) {
            throw new NotFoundException(msgVehicule + " avec id : " + id);
        }
        vehiculeRepository.deleteById(id);
    }


    @Override
    public List<Vehicule> findByClient(Long id) {
        Client c=clientRepository.findById(id).orElseThrow(()->new NotFoundException(msgClient));
        return vehiculeRepository.findByClient(id);
    }

}

