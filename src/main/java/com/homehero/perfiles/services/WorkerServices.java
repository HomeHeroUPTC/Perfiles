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
public class WorkerServices {
    @Autowired
    private WorkerRepo workerRepo;

}
