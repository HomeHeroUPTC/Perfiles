package com.homehero.perfiles.controllers;

import com.homehero.perfiles.PerfilesDTO.ClientDTO;
import com.homehero.perfiles.PerfilesDTO.HeroAgendaDTO;
import com.homehero.perfiles.PerfilesDTO.HeroDTO;
import com.homehero.perfiles.models.Client;
import com.homehero.perfiles.models.ErrorResponse;
import com.homehero.perfiles.models.Hero;
import com.homehero.perfiles.services.ClientServices;
import com.homehero.perfiles.services.HeroServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/User")
public class Controller {

    @Autowired
    private HeroServices heroServices;

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

    @PostMapping(value = "/CreateHero")
    public ResponseEntity<?> CreateHero(@RequestBody Hero hero){
        try {
            heroServices.createHero(hero);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse("An error occurred while fetching services: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/GetHeroByMail")
    public ResponseEntity<?> GetHeroByMail(@RequestParam String hero_mail) {
        try {
            HeroDTO hero = heroServices.getHeroByMail(hero_mail);
            return new ResponseEntity<>(hero, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse("An error occurred while fetching services: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/GetHeroAgenda")
    public ResponseEntity<?> getHeroAgenda(@RequestParam int hero_id) {
        try {
            HeroAgendaDTO heroAgenda = heroServices.getHeroAgenda(hero_id);
            return new ResponseEntity<>(heroAgenda, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse("An error occurred while fetching services: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/GetHeroName")
    public ResponseEntity<?> GetHeroName(@RequestParam int hero_id) {
        try {
            String name = heroServices.GetHeroName(hero_id);
            return new ResponseEntity<>(name, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse("An error occurred while fetching services: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/GetClientName")
    public ResponseEntity<?> GetClientName(@RequestParam int client_id) {
        try {
            String name = heroServices.GetClientName(client_id);
            return new ResponseEntity<>(name, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse("An error occurred while fetching services: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/GetHeroNeighborhood")
    public ResponseEntity<?> GetHeroNeighborhood(@RequestParam int hero_id) {
        try {
            String neighborhood = heroServices.GetHeroNeighborhood(hero_id);
            return new ResponseEntity<>(neighborhood, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse("An error occurred while fetching services: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
