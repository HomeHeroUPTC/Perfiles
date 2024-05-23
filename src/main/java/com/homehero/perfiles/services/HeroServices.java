package com.homehero.perfiles.services;

import com.homehero.perfiles.PerfilesDTO.ClientDTO;
import com.homehero.perfiles.PerfilesDTO.HeroDTO;
import com.homehero.perfiles.models.Hero;
import com.homehero.perfiles.repositories.HeroRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroServices {
    @Autowired
    private HeroRepo workerRepo;

    @Autowired
    private EntityManager entityManager;

    public void createHero(Hero hero) {
        workerRepo.save(hero);

    }

    public HeroDTO getHeroByMail(String heroMail) {
        String q = String.format("SELECT h.id, h.name, h.image_url, h.address FROM Hero h WHERE h.email = '%s'", heroMail);
        TypedQuery<Object[]> query = entityManager.createQuery(q, Object[].class);
        List<Object[]> results = query.getResultList();
        HeroDTO hero = new HeroDTO();
        Object[] result = results.get(0);
        hero.setId((int) result[0]);
        hero.setName((String) result[1]);
        hero.setImage_url((String) result[2]);
        hero.setAddress((String) result[3]);
        return hero;
    }
}
