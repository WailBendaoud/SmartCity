package com.example.noSqlProject.controllers;

import com.example.noSqlProject.entities.mysql.Client;
import com.example.noSqlProject.entities.mysql.Paiement;
import com.example.noSqlProject.enumeration.TypeAbonnement;
import com.example.noSqlProject.services.impl.PaiementService;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/paiement")
public class PaiementController {

    private final PaiementService paiementService;

    public PaiementController(PaiementService paiementService) {
        this.paiementService = paiementService;
    }

    @PostMapping("/creer")
    public ResponseEntity<Paiement> creerPaiementAvecAbonnement(@RequestBody PaiementRequest request) {

        // 🔹 Créer l'objet Paiement avec le client et le montant
        Paiement paiement = new Paiement();
        Client client = new Client();
        client.setId(request.getClientId());
        paiement.setClient(client);
        paiement.setMontant(request.getMontant());


        Paiement savedPaiement = paiementService.savePaiementEtAbonnement(
                paiement,
                request.getTypeAbonnement(),
                request.getParkingId()

        );


        return ResponseEntity.ok(savedPaiement);
    }
}
