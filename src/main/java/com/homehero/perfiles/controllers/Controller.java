package com.homehero.perfiles.controllers;

import com.homehero.perfiles.PerfilesDTO.ClientDTO;
import com.homehero.perfiles.models.Client;
import com.homehero.perfiles.models.ErrorResponse;
import com.homehero.perfiles.services.ClientServices;
import com.homehero.perfiles.services.WorkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/User")
public class Controller {

    @Autowired
    private WorkerServices workerServices;

    @Autowired
    private ClientServices clientServices;

    @PostMapping(value = "/CreateClient")
    public ResponseEntity<?> CreateClient(@RequestBody Client client){
        try {
            clientServices.createClient(client);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse("An error occurred while fetching services: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/GetClientByMail")
    public ResponseEntity<?> GetClientByMail(@RequestParam String client_mail) {
        try {
            ClientDTO client = clientServices.getClientByMail(client_mail);
            return new ResponseEntity<>(client, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse("An error occurred while fetching services: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
