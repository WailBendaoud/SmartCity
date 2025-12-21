package com.example.noSqlProject.services.impl;

import com.example.noSqlProject.entities.mongo.*;
import com.example.noSqlProject.exceptions.NotFoundException;
import com.example.noSqlProject.repositories.mongo.AvenueRepository;
import com.example.noSqlProject.repositories.mongo.TypeCapteurRepository;
import com.example.noSqlProject.services.api.AvenueService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

public class AvenueServiceImpl implements AvenueService {

    private final AvenueRepository avenueRepository;
    private final TypeCapteurRepository typeCapteurRepository;
    private final String msgAvenue="Avenue introuvable";

    public AvenueServiceImpl(AvenueRepository avenueRepository, TypeCapteurRepository typeCapteurRepository) {
        this.avenueRepository = avenueRepository;
        this.typeCapteurRepository = typeCapteurRepository;
    }


    @Override
    public List<Avenue> getAll() {
        return avenueRepository.findAll();
    }

    @Override
    public Avenue findById(String id) {
        return avenueRepository.findById(id).orElseThrow(()->new NotFoundException(msgAvenue));
    }

    @Override
    public Avenue save(Avenue avenue) {
        List<String> ls=new ArrayList<>();
        avenue.setCameras(new ArrayList<>());
        avenue.setCapteurs(new ArrayList<>());
        avenue.setStations(new ArrayList<>());
        avenue.setStationBus(new ArrayList<>());
        avenue.setFeuSignalisation(new ArrayList<>());
        avenue.setRadars(ls);
        avenue.setParkings(ls);
        return avenueRepository.save(avenue);
    }

    @Override
    public Avenue update(Avenue element, String id) {
        Avenue a=findById(id);
        a.setNom(element.getNom());
        a.setLongueur(element.getLongueur());
        a.setLargeur(element.getLargeur());
        a.setNbvoies(element.getNbvoies());
        a.setVille(element.getVille());
        a.setCode_postal(element.getCode_postal());
        a.setCoordonees(element.getCoordonees());

        return avenueRepository.save(a);
    }

    @Override
    public void deleteById(String id) {
      Avenue avenue=findById(id);
      avenueRepository.deleteById(id);
    }


    @Override
    public Avenue addCamera(String idAvenue, List<Camera> cameras) {

        Avenue avenue = avenueRepository.findById(idAvenue)
                .orElseThrow(() ->
                        new NotFoundException("Avenue introuvable avec id : " + idAvenue)
                );

        if (avenue.getCameras() == null) {
            avenue.setCameras(new ArrayList<>());
        }

        cameras.forEach(c->{
            avenue.getCameras().add(c);
        });

        return avenueRepository.save(avenue);

    }


    @Override
    public Avenue addStation(String idAvenue, List<Station> stations) {

        Avenue avenue = avenueRepository.findById(idAvenue)
                .orElseThrow(() ->
                        new NotFoundException("Avenue introuvable avec id : " + idAvenue)
                );

        if (avenue.getStations() == null) {
            avenue.setStations(new ArrayList<>());
        }

        stations.forEach(s -> avenue.getStations().add(s));

        return avenueRepository.save(avenue);
    }


    @Override
    public Avenue addCapteure(String idAvenue, List<Capteur> capteurs) {

        Avenue avenue = avenueRepository.findById(idAvenue)
                .orElseThrow(() ->
                        new NotFoundException("Avenue introuvable avec id : " + idAvenue)
                );

        if (avenue.getCapteurs() == null) {
            avenue.setCapteurs(new ArrayList<>());
        }

        capteurs.forEach(c -> {
            String typeId = c.getTypeCapteur().getId();
            TypeCapteur typeCapteur = typeCapteurRepository.findById(typeId)
                    .orElseThrow(() -> new NotFoundException(
                            "TypeCapteur introuvable avec id : " + typeId
                    ));
            c.setTypeCapteur(typeCapteur); // ici tu as l'objet complet
            avenue.getCapteurs().add(c);
        });

// ensuite, avant de retourner l'objet, tu peux forcer le mapping
        avenue.getCapteurs().forEach(c -> {
            c.setTypeCapteur(typeCapteurRepository.findById(c.getTypeCapteur().getId()).orElse(null));
        });


        return avenueRepository.save(avenue);
    }



    @Override
    public Avenue addParking(String idAvenue, String idParking) {
        Avenue avenue = avenueRepository.findById(idAvenue)
                .orElseThrow(() -> new NotFoundException("Avenue introuvable avec id : " + idAvenue));

        if (avenue.getParkings() == null) {
            avenue.setParkings(new ArrayList<>());
        }

        if (!avenue.getParkings().contains(idParking)) {
            avenue.getParkings().add(idParking);
        }

        return avenueRepository.save(avenue);
    }

    @Override
    public Avenue addParkings(String idAvenue, List<String> idParkingList) {
        Avenue avenue = avenueRepository.findById(idAvenue)
                .orElseThrow(() -> new NotFoundException("Avenue introuvable avec id : " + idAvenue));

        if (avenue.getParkings() == null) {
            avenue.setParkings(new ArrayList<>());
        }

        idParkingList.forEach(id -> {
            if (!avenue.getParkings().contains(id)) {
                avenue.getParkings().add(id);
            }
        });

        return avenueRepository.save(avenue);
    }

    @Override
    public Avenue addStationBus(String idAvenue, List<StationBus> stationsBus) {
        Avenue avenue = avenueRepository.findById(idAvenue)
                .orElseThrow(() -> new NotFoundException("Avenue introuvable avec id : " + idAvenue));

        if (avenue.getStationBus() == null) {
            avenue.setStationBus(new ArrayList<>());
        }

        stationsBus.forEach(avenue.getStationBus()::add);

        return avenueRepository.save(avenue);
    }

    @Override
    public Avenue addFeu(String idAvenue, List<FeuSignalisation> feuSignalisations) {
        Avenue avenue = avenueRepository.findById(idAvenue)
                .orElseThrow(() -> new NotFoundException("Avenue introuvable avec id : " + idAvenue));

        if (avenue.getFeuSignalisation() == null) {
            avenue.setFeuSignalisation(new ArrayList<>());
        }

        feuSignalisations.forEach(avenue.getFeuSignalisation()::add);

        return avenueRepository.save(avenue);
    }

}
