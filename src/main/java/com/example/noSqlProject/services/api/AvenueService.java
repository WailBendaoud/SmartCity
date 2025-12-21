package com.example.noSqlProject.services.api;

import com.example.noSqlProject.entities.mongo.*;
import com.example.noSqlProject.services.GenericService;

import java.util.List;

public interface AvenueService extends GenericService<Avenue,String> {
    Avenue addCamera(String idAvenue,List<Camera>cameras);

    Avenue addStation(String idAvenue,List<Station>stations);
    Avenue addCapteure(String idAvenue,List<Capteur>capteurs);
    Avenue addParking(String idAvenue,String idParking);
    Avenue addParkings(String idAvenue,List<String> idParking);
    Avenue addStationBus(String idAvenue,List<StationBus>stationsBus);
    Avenue addFeu(String idAvenue,List<FeuSignalisation> feuSignalisations);

}
