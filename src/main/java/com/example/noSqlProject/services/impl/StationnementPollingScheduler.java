package com.example.noSqlProject.services.impl;

import com.example.noSqlProject.entities.mongo.Parking;
import com.example.noSqlProject.entities.mongo.Stationnement;
import com.example.noSqlProject.repositories.mongo.ParkingRepository;
import com.example.noSqlProject.repositories.mongo.StationnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StationnementPollingScheduler {

    @Autowired
    private StationnementRepository stationnementRepo;

    @Autowired
    private ParkingRepository parkingRepository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // Map parkingId -> dernier check
    private final Map<String, Instant> lastCheckMap = new HashMap<>();

    @Scheduled(fixedRate = 5000)
    public void pollStationnements() {
        // 🔹 Récupérer tous les parkings
        List<Parking> parkings = parkingRepository.findAll();

        for (Parking p : parkings) {
            String parkingId = p.getId();
            Instant lastCheck = lastCheckMap.getOrDefault(parkingId, Instant.now().minusSeconds(5));

            // 🔹 Récupérer les nouveaux stationnements en cours
            List<Stationnement> newStationnements =
                    stationnementRepo.findByParkingIdAndDateHeureSortieIsNullAndCreatedAtAfter(parkingId, lastCheck);

            // 🔹 Envoyer via WebSocket uniquement si insertion détectée
            newStationnements.forEach(st -> {
                messagingTemplate.convertAndSend(
                        "/topic/parking/" + parkingId + "/stationnement",
                        st
                );
            });

            // 🔹 Mettre à jour le dernier check pour ce parking
            lastCheckMap.put(parkingId, Instant.now());
        }
    }
}
