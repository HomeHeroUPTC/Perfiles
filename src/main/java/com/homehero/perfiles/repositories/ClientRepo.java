package com.homehero.perfiles.repositories;

import com.homehero.perfiles.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client,Integer> {
}
