package com.homehero.perfiles.services;

import com.homehero.perfiles.models.Worker;
import com.homehero.perfiles.models.Client;
import com.homehero.perfiles.repositories.WorkerRepo;
import com.homehero.perfiles.repositories.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class Services {

    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private WorkerRepo workerRepo;

    public Client createClient(Client client){
        return clientRepo.save(client);
    }

    public Worker createWorker(Worker worker){
        return workerRepo.save(worker);
    }

    public Optional<Client> updateClient(long id, Client client){
        if (!clientRepo.existsById((int) id)){
            return Optional.empty();
        }
        client.setId(id);
        return Optional.of(clientRepo.save(client));
    }

    public Optional<Worker> updateWorker(long id, Worker worker){
        if (!workerRepo.existsById((int) id)){
            return Optional.empty();
        }
        worker.setId(id);
        return Optional.of(workerRepo.save(worker));
    }

    public boolean deletedClient(int id){
        if (!clientRepo.existsById(id)){
            return false;
        }
        clientRepo.deleteById(id);
        return true;
    }

    public boolean deletedWorker(int id){
        if (!workerRepo.existsById(id)){
            return false;
        }
        workerRepo.deleteById(id);
        return true;
    }

    public List<Client> getAllClients(){
        return clientRepo.findAll();
    }

    public List<Worker> getAllWorkers(){
        return workerRepo.findAll();
    }

    public Optional<Client> getClientById(int id){
        return clientRepo.findById(id);
    }

    public Optional<Worker> getWorkerById(int id){
        return workerRepo.findById(id);
    }
}
