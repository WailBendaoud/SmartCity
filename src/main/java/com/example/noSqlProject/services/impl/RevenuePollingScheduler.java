package com.example.noSqlProject.services.impl;

import com.example.noSqlProject.entities.mongo.Parking;
import com.example.noSqlProject.entities.mongo.Revenue;
import com.example.noSqlProject.repositories.mongo.ParkingRepository;
import com.example.noSqlProject.repositories.mongo.RevenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RevenuePollingScheduler {

    @Autowired
    private RevenueRepository revenueRepository;

    @Autowired
    private ParkingRepository parkingRepository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // Map parkingId -> dernier check
    private final Map<String, Instant> lastCheckMap = new HashMap<>();

    @Scheduled(fixedRate = 5000)
    public void pollRevenues() {
        // 🔹 Récupérer tous les parkings
        List<Parking> parkings = parkingRepository.findAll();

        for (Parking p : parkings) {
            String parkingId = p.getId();
            Instant lastCheck = lastCheckMap.getOrDefault(parkingId, Instant.now().minusSeconds(5));

            // 🔹 Récupérer les nouveaux revenus de ce parking
            List<Revenue> newRevenues =
                    revenueRepository.findByParkingIdAndCreatedAtAfter(parkingId, lastCheck);

            // 🔹 Envoyer via WebSocket uniquement si nouveaux
            newRevenues.forEach(rv -> {
                messagingTemplate.convertAndSend(
                        "/topic/parking/" + parkingId + "/revenue",
                        rv
                );
            });

            // 🔹 Mettre à jour le dernier check pour ce parking
            lastCheckMap.put(parkingId, Instant.now());
        }
    }
}
