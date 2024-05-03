package com.homehero.perfiles.controllers;

import com.homehero.perfiles.models.Trabajador;
import com.homehero.perfiles.models.Usuario;
import com.homehero.perfiles.services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/homeHero-Perfiles")
public class Controller {

    @Autowired
    private Services service;

    @GetMapping(value = "/usuarios")
    public List<Usuario> getAllUsuarios(){
        return service.getAllUsuarios();
    }

    @GetMapping(value = "/trabajadores")
    public List<Trabajador> getAllTrabajadores(){
        return service.getAllTrabajadores();
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable("id") int id) {
        Optional<Usuario> usuarioById = service.getUsuarioById(id);
        return usuarioById.map(ResponseEntity::ok).orElseGet(
                () -> ResponseEntity.notFound().build());
    }

    @GetMapping("/trabajador/{id}")
    public ResponseEntity<Trabajador> getTrabajadorById(@PathVariable("id") int id) {
        Optional<Trabajador> trabajadorById = service.getTrabajadorById(id);
        return trabajadorById.map(ResponseEntity::ok).orElseGet(
                () -> ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/usuario")
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario){
        Usuario createUsuario = service.createUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUsuario);
    }

    @PostMapping(value = "/trabajador")
    public ResponseEntity<Trabajador> createTrabajador(@RequestBody Trabajador trabajador){
        Trabajador createTrabajador = service.createTrabajador(trabajador);
        return ResponseEntity.status(HttpStatus.CREATED).body(createTrabajador);
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable("id") int id, @RequestBody Usuario usuario) {
        Optional<Usuario> updateUsuario = service.updateUsuario(id, usuario);
        return updateUsuario.map(ResponseEntity::ok).orElseGet(
                () -> ResponseEntity.noContent().build());
    }

    @PutMapping("/trabajador/{id}")
    public ResponseEntity<Trabajador> updateTrabajador(@PathVariable("id") int id, @RequestBody Trabajador trabajador) {
        Optional<Trabajador> updateTrabajador = service.updateTrabajador(id, trabajador);
        return updateTrabajador.map(ResponseEntity::ok).orElseGet(
                () -> ResponseEntity.noContent().build());
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<Void> deletedusuarioById(@PathVariable("id") int id){
        boolean deleted = service.deletedUsuario(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/trabajador/{id}")
    public ResponseEntity<Void> deletedTrabajadorById(@PathVariable("id") int id){
        boolean deleted = service.deletedTrabajador(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
