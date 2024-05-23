package com.homehero.perfiles.repositories;

import com.homehero.perfiles.models.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepo extends JpaRepository<Hero,Integer> {
}
