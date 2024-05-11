package com.homehero.perfiles.controllers;

import com.homehero.perfiles.models.Worker;
import com.homehero.perfiles.models.Client;
import com.homehero.perfiles.services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/Perfiles")
public class Controller {

    @Autowired
    private Services service;

    @GetMapping(value = "/Clients")
    public List<Client> getAllClients(){
        return service.getAllClients();
    }

    @GetMapping(value = "/Workers")
    public List<Worker> getAllWorkers(){
        return service.getAllWorkers();
    }

    @GetMapping("/Client/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") int id) {
        Optional<Client> ClientById = service.getClientById(id);
        return ClientById.map(ResponseEntity::ok).orElseGet(
                () -> ResponseEntity.notFound().build());
    }

    @GetMapping("/Worker/{id}")
    public ResponseEntity<Worker> getWorkerById(@PathVariable("id") int id) {
        Optional<Worker> WorkerById = service.getWorkerById(id);
        return WorkerById.map(ResponseEntity::ok).orElseGet(
                () -> ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/Client")
    public ResponseEntity<Client> createClient(@RequestBody Client client){
        Client createClient = service.createClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(createClient);
    }

    @PostMapping(value = "/Worker")
    public ResponseEntity<Worker> createWorker(@RequestBody Worker worker){
        Worker createWorker = service.createWorker(worker);
        return ResponseEntity.status(HttpStatus.CREATED).body(createWorker);
    }

    @PutMapping("/Client/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id") int id, @RequestBody Client client) {
        Optional<Client> updateClient = service.updateClient(id, client);
        return updateClient.map(ResponseEntity::ok).orElseGet(
                () -> ResponseEntity.noContent().build());
    }

    @PutMapping("/Worker/{id}")
    public ResponseEntity<Worker> updateWorker(@PathVariable("id") int id, @RequestBody Worker worker) {
        Optional<Worker> updateWorker = service.updateWorker(id, worker);
        return updateWorker.map(ResponseEntity::ok).orElseGet(
                () -> ResponseEntity.noContent().build());
    }

    @DeleteMapping("/Client/{id}")
    public ResponseEntity<Void> deletedClientById(@PathVariable("id") int id){
        boolean deleted = service.deletedClient(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/Worker/{id}")
    public ResponseEntity<Void> deletedWorkerById(@PathVariable("id") int id){
        boolean deleted = service.deletedWorker(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
