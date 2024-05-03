package com.homehero.perfiles.services;

import com.homehero.perfiles.models.Trabajador;
import com.homehero.perfiles.models.Usuario;
import com.homehero.perfiles.repositories.TrabajadorRepository;
import com.homehero.perfiles.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class Services {

    @Autowired
    private UsuarioRepository repositoryUsuario;

    @Autowired
    private TrabajadorRepository repositoryTrabajador;

    public Usuario createUsuario(Usuario usuario){
        return repositoryUsuario.save(usuario);
    }

    public Trabajador createTrabajador(Trabajador trabajador){
        return repositoryTrabajador.save(trabajador);
    }

    public Optional<Usuario> updateUsuario(int id, Usuario usuario){
        if (!repositoryUsuario.existsById(id)){
            return Optional.empty();
        }
        usuario.setId_usuario(id);
        return Optional.of(repositoryUsuario.save(usuario));
    }

    public Optional<Trabajador> updateTrabajador(int id, Trabajador trabajador){
        if (!repositoryTrabajador.existsById(id)){
            return Optional.empty();
        }
        trabajador.setId_trabajador(id);
        return Optional.of(repositoryTrabajador.save(trabajador));
    }

    public boolean deletedUsuario(int id){
        if (!repositoryUsuario.existsById(id)){
            return false;
        }
        repositoryUsuario.deleteById(id);
        return true;
    }

    public boolean deletedTrabajador(int id){
        if (!repositoryTrabajador.existsById(id)){
            return false;
        }
        repositoryTrabajador.deleteById(id);
        return true;
    }

    public List<Usuario> getAllUsuarios(){
        return repositoryUsuario.findAll();
    }

    public List<Trabajador> getAllTrabajadores(){
        return repositoryTrabajador.findAll();
    }

    public Optional<Usuario> getUsuarioById(int id){
        return repositoryUsuario.findById(id);
    }

    public Optional<Trabajador> getTrabajadorById(int id){
        return repositoryTrabajador.findById(id);
    }
}
