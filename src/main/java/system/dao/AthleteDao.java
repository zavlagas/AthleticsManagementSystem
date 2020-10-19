/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.dao;

import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
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
        return (athletes);
    }

    public String insertAthleteIfNotExistsToDatabase(Athlete athlete) {
        String processInfo = null;
        EntityManager em = openConnection();
        em.getTransaction().begin();
        try {
            em.persist(athlete);
            em.getTransaction().commit();
            processInfo = "The Athlete Added";
        } catch (EntityExistsException ex) {
            processInfo = "Athlete exists in our list, try again";
        } finally {
            closeConnection();
        }
        return (processInfo);
    }
}
