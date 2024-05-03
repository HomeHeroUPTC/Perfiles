package com.homehero.perfiles.repositories;

import com.homehero.perfiles.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
}
