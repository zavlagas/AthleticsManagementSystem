/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import system.entities.Coach;

/**
 *
 * @author User
 */
public class CoachDao extends SuperDaoManagerFactory {

    public List<Coach> getCoachesFromDatabase() {
        EntityManager em = openConnection();
        List<Coach> coaches = em.createNamedQuery("Coach.findAll", Coach.class).getResultList();
        closeAndClearConnection();
        return (coaches);
    }

    public String insertCoachToDatabase(Coach coach) {
        String processInfo = null;
        EntityManager em = openConnection();
        em.getTransaction().begin();
        boolean exist = checkIfNotExists(em, coach);
        if (exist) {
            processInfo = "Coach exists in our list, try again";
        } else {
            em.persist(coach);
            processInfo = "The Coach Added";
        }
        em.getTransaction().commit();
        closeAndClearConnection();
        return (processInfo);
    }

    public boolean checkIfNotExists(EntityManager em, Coach coach) {
        boolean exist = true;
        try {
            Coach co = em.createNamedQuery("Coach.findIfExists", Coach.class).setParameter("name", coach.getName()).setParameter("salary", coach.getSalary()).getSingleResult();
        } catch (NoResultException ex) {
            exist = false;
        } finally {
            return (exist);
        }

    }

    public String deleteCoachToDatabaseBy(int coachId) {
        EntityManager em = openConnection();
        em.getTransaction().begin();
        em.remove(em.getReference(Coach.class, coachId));
        em.getTransaction().commit();
        closeAndClearConnection();
        return ("The Coach Deleted");
    }

    public Coach fetchCoachFromDatabaseBy(int coachId) {
        EntityManager em = openConnection();
        Coach coach = em.createNamedQuery("Coach.findByCid", Coach.class)
                .setParameter("cid", coachId)
                .getSingleResult();

        closeAndClearConnection();
        return (coach);
    }

    public String updateCoachToDatabase(Coach coach) {
        EntityManager em = openConnection();
        em.getTransaction().begin();
        Coach c = em.merge(coach);
        c.setName(coach.getName());
        c.setSalary(coach.getSalary());
        em.getTransaction().commit();
        closeAndClearConnection();
        return ("The Coach Updated");
    }

}
