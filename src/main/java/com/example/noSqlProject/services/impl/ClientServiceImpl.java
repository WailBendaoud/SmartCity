package com.example.noSqlProject.services.impl;

import com.example.noSqlProject.entities.mysql.Client;
import com.example.noSqlProject.entities.mysql.PointFidelite;
import com.example.noSqlProject.exceptions.NotFoundException;
import com.example.noSqlProject.repositories.mysql.ClientRepository;
import com.example.noSqlProject.repositories.mysql.PointdeFideliteRepository;
import com.example.noSqlProject.services.api.ClientService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final PointdeFideliteRepository pointdeFideliteRepository;

    public ClientServiceImpl(ClientRepository clientRepository, PointdeFideliteRepository pointdeFideliteRepository) {
        this.clientRepository = clientRepository;
        this.pointdeFideliteRepository = pointdeFideliteRepository;
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException("Client  introuvable"));
    }

    @Override
    public Client save(Client client) {
        client.setDateInscription(new Date());
        var p=pointdeFideliteRepository.save(new PointFidelite(0));
        client.setPointFidelite(p);
        return clientRepository.save(client);
    }

    @Override
    public Client update(Client client, Long id) {
        Client existingClient = findById(id);

        // 🔁 mise à jour des champs (exemple)
        existingClient.setNom(client.getNom());
        existingClient.setEmail(client.getEmail());
        existingClient.setPrenom(client.getPrenom());
        //existingClient.setTelephone(client.getTelephone());

        return clientRepository.save(existingClient);
    }



    @Override
    public void deleteById(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new NotFoundException(
                    "Client avec l'id " + id + " introuvable");
        }
        clientRepository.deleteById(id);
    }
}
