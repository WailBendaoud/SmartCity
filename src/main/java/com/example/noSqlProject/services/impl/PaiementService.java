package com.example.noSqlProject.services.impl;

import com.example.noSqlProject.entities.mongo.Parking;
import com.example.noSqlProject.entities.mongo.Revenue;
import com.example.noSqlProject.entities.mysql.Abonnement;
import com.example.noSqlProject.entities.mysql.Client;
import com.example.noSqlProject.entities.mysql.Paiement;
import com.example.noSqlProject.enumeration.EtatAbonnement;
import com.example.noSqlProject.enumeration.TypeAbonnement;
import com.example.noSqlProject.enumeration.TypeRevenue;
import com.example.noSqlProject.exceptions.NotFoundException;
import com.example.noSqlProject.repositories.mongo.ParkingRepository;
import com.example.noSqlProject.repositories.mongo.RevenueRepository;
import com.example.noSqlProject.repositories.mysql.AbonnementRepository;
import com.example.noSqlProject.repositories.mysql.ClientRepository;
import com.example.noSqlProject.repositories.mysql.PaiementRepository;
import com.example.noSqlProject.services.api.RevenueService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class PaiementService {

    private final PaiementRepository paiementRepository;
    private final AbonnementRepository abonnementRepository;
    private final ClientRepository clientRepository;
    private final ParkingRepository parkingRepository;
    private final RevenueService revenueService;

    public PaiementService(PaiementRepository paiementRepository,
                           AbonnementRepository abonnementRepository,
                           ClientRepository clientRepository, ParkingRepository parkingRepository, RevenueService revenueService) {
        this.paiementRepository = paiementRepository;
        this.abonnementRepository = abonnementRepository;
        this.clientRepository = clientRepository;
        this.parkingRepository = parkingRepository;
        this.revenueService = revenueService;
    }

    @Transactional
    public Paiement savePaiementEtAbonnement(Paiement p, TypeAbonnement type, String idParking) {

        Client c = clientRepository.findById(p.getClient().getId())
                .orElseThrow(() -> new NotFoundException("Client introuvable"));
        Parking parking =parkingRepository.findById(idParking).orElseThrow(()->new NotFoundException("Parking introuvable"));

        // 🔹 Vérifier si le client a déjà un abonnement actif
        Abonnement abonnementActif = abonnementRepository
                .findByClientIdAndEtatAbonnement(c.getId(), EtatAbonnement.ACTIF);

        if (abonnementActif != null) {
            abonnementActif.setEtatAbonnement(EtatAbonnement.EXPIRE);
            abonnementRepository.save(abonnementActif);
        }

        // 🔹 Créer le paiement avec abonnement = null
        p.setAbonnement(null);
        p.setDatePaiment(new Date());
        p.setClient(c);
        Paiement paiement = paiementRepository.save(p);

        // 🔹 Créer le nouvel abonnement
        Abonnement a = new Abonnement();
        a.setClient(c);
        a.setEtatAbonnement(EtatAbonnement.ACTIF);
        a.setDateDebut(new Date());
        a.setParkingId(idParking);
        a.setTypeAbonnement(type);
        a.setPrix(p.getMontant());

        // 🔹 Calcul date de fin
        Calendar cal = Calendar.getInstance();
        cal.setTime(a.getDateDebut());
        switch (type) {
            case MENSUEL -> cal.add(Calendar.MONTH, 1);
            case TRIMESTRIEL -> cal.add(Calendar.MONTH, 3);
            case ANNUEL -> cal.add(Calendar.YEAR, 1);
            default -> throw new IllegalArgumentException("Type d'abonnement inconnu : " + type);
        }
        a.setDateFin(cal.getTime());

        // 🔹 Sauvegarder l'abonnement
        abonnementRepository.save(a);
        Revenue r=new Revenue();
        r.setParking(parking);
        r.setMontant(p.getMontant());
        r.setType(TypeRevenue.ABONNEMENT_MENSUEL);
        r.setDescription("Abonement "+ type);
        revenueService.save(r);


        // 🔹 Lier le paiement au nouvel abonnement et le sauvegarder
        paiement.setAbonnement(a);
        paiementRepository.save(paiement);

        // 🔹 Retourner le paiement complet (avec abonnement lié)
        return paiement;
    }






}
