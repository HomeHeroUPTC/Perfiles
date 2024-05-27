package com.homehero.perfiles.services;

import com.homehero.perfiles.PerfilesDTO.ClientDTO;
import com.homehero.perfiles.PerfilesDTO.HeroAgendaDTO;
import com.homehero.perfiles.PerfilesDTO.HeroDTO;
import com.homehero.perfiles.models.Hero;
import com.homehero.perfiles.repositories.HeroRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
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

    public HeroAgendaDTO getHeroAgenda(int hero_id) {
        Hero hero = workerRepo.findById(hero_id).get();
        HeroAgendaDTO agenda = new HeroAgendaDTO();
        agenda.setInit_hour(hero.getInit_hour());
        agenda.setEnd_hour(hero.getEnd_hour());
        agenda.setDaysOfWeek(hero.getWork_days());
        return agenda;
    }

    public String GetHeroNeighborhood(int heroId) {
        String q = "SELECT h.neighborhood FROM Hero h WHERE h.id = :heroId";
        TypedQuery<String> query = entityManager.createQuery(q, String.class);
        query.setParameter("heroId", heroId);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            // Manejar el caso en que no se encuentra ningún resultado
            return null; // o lanzar una excepción personalizada
        }
    }

    public String GetHeroName(int heroId) {
        String q = "SELECT h.name FROM Hero h WHERE h.id = :heroId";
        TypedQuery<String> query = entityManager.createQuery(q, String.class);
        query.setParameter("heroId", heroId);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            // Manejar el caso en que no se encuentra ningún resultado
            return null; // o lanzar una excepción personalizada
        }
    }

    public String GetClientName(int clientid) {
        String q = "SELECT c.name FROM Client c WHERE c.id = :clientid";
        TypedQuery<String> query = entityManager.createQuery(q, String.class);
        query.setParameter("clientid", clientid);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            // Manejar el caso en que no se encuentra ningún resultado
            return null; // o lanzar una excepción personalizada
        }
    }
}
