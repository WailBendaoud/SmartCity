package com.example.noSqlProject.services.impl;

import com.example.noSqlProject.entities.mongo.Revenue;
import com.example.noSqlProject.entities.mongo.Stationnement;
import com.example.noSqlProject.repositories.mongo.RevenueRepository;
import com.example.noSqlProject.repositories.mongo.StationnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
public class InsertPollingScheduler {

    @Autowired
    private StationnementRepository stationnementRepo;

    @Autowired
    private RevenueRepository revenueRepo;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    private Instant lastCheck = Instant.now();

    @Scheduled(fixedRate = 5000)
    public void pollAndNotify() {

        // 🔹 Nouveaux stationnements
        List<Stationnement> newStationnements =
                stationnementRepo.findByCreatedAtAfter(lastCheck);

        // 🔹 Nouveaux revenues
        List<Revenue> newRevenues =
                revenueRepo.findByCreatedAtAfter(lastCheck);

        /* =======================
           STATIONNEMENT PAR PARKING
           ======================= */
        newStationnements.forEach(st -> {
            String parkingId = st.getParking().getId();

            messagingTemplate.convertAndSend(
                    "/topic/parking/" + parkingId + "/stationnement",
                    st
            );
        });

        /* =======================
           REVENUE PAR PARKING
           ======================= */
        newRevenues.forEach(rv -> {
            String parkingId = rv.getParking().getId();

            messagingTemplate.convertAndSend(
                    "/topic/parking/" + parkingId + "/revenue",
                    rv
            );
        });

        lastCheck = Instant.now();
    }
}

