/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.dao;

import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import system.entities.Athlete;

/**
 *
 * @author User
 */
public class AthleteDao extends SuperDaoManagerFactory {

    public List<Athlete> getAthletesFromDatabase() {
        EntityManager em = openConnection();
        TypedQuery query = em.createNamedQuery("Athlete.findAll", Athlete.class);
        List<Athlete> athletes = query.getResultList();
        closeAndClearConnection();
        return (athletes);
    }

    public String insertAthleteToDatabase(Athlete athlete) {
        String processInfo = null;
        EntityManager em = openConnection();
        em.getTransaction().begin();
        boolean exist = checkIfNotExists(em, athlete);
        if (exist) {
            processInfo = "Athlete exists in our list, try again";
        } else {
            em.persist(athlete);
            processInfo = "The Athlete Added";
        }
        em.getTransaction().commit();
        closeAndClearConnection();
        return (processInfo);
    }

    public boolean checkIfNotExists(EntityManager em, Athlete athlete) {
        boolean exist = true;
        try {
            Athlete ath = em.createNamedQuery("Athlete.findIfExists", Athlete.class).setParameter("name", athlete.getName()).setParameter("height", athlete.getHeight()).
                    setParameter("weight", athlete.getWeight()).setParameter("dob", athlete.getDob()).getSingleResult();
        } catch (NoResultException ex) {
            exist = false;
        } finally {
            return (exist);
        }

    }

    public String deleteAthleteToDatabaseBy(int athleteId) {
        EntityManager em = openConnection();
        em.getTransaction().begin();
        em.remove(em.getReference(Athlete.class, athleteId));
        em.getTransaction().commit();
        closeAndClearConnection();
        return ("The Athlete has been Deleted");
    }

    public Athlete fetchAthleteFromDatabaseBy(int athleteId) {
        EntityManager em = openConnection();
        Athlete ath = em.createNamedQuery("Athlete.findByAid", Athlete.class).setParameter("aid", athleteId).getSingleResult();
        closeAndClearConnection();
        return (ath);
    }

    public String updateAthleteToDatabaseBy(Athlete ath) {
        EntityManager em = openConnection();

        em.getTransaction().begin();
        Athlete athlete = em.merge(ath);
        athlete.setName(ath.getName());
        athlete.setHeight(ath.getHeight());
        athlete.setWeight(ath.getWeight());
        athlete.setDob(ath.getDob());
        em.getTransaction().commit();
        closeAndClearConnection();
        return ("The Athlete Updated");
    }
}
