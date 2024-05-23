package com.homehero.perfiles.services;

import com.homehero.perfiles.PerfilesDTO.ClientDTO;
import com.homehero.perfiles.models.Client;
import com.homehero.perfiles.models.Worker;
import com.homehero.perfiles.repositories.ClientRepo;
import com.homehero.perfiles.repositories.WorkerRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServices {

    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private EntityManager entityManager;

    public void createClient(Client client) {
        clientRepo.save(client);
    }

    public ClientDTO getClientByMail(String clientMail) {
        String q = String.format("SELECT c.id, c.name, c.image_url, c.address FROM Client c WHERE c.email = %s", clientMail);
        TypedQuery<Object[]> query = entityManager.createQuery(q, Object[].class);
        List<Object[]> results = query.getResultList();
        ClientDTO client = new ClientDTO();
        Object[] result = results.get(0);
        client.setId((int) result[0]);
        client.setName((String) result[1]);
        client.setImage_url((String) result[2]);
        client.setAddress((String) result[3]);
        return client;
    }
}
