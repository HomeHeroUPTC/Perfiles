package com.homehero.perfiles.repositories;

import com.homehero.perfiles.models.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepo extends JpaRepository<Worker,Integer> {
}
