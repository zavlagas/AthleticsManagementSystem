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

    public String insertAthleteToDatabase(Athlete athlete) {
        String processInfo = null;
        EntityManager em = openConnection();
        em.getTransaction().begin();
        boolean exist = checkIfNotExists(athlete);
        if (exist) {
            processInfo = "Athlete exists in our list, try again";
        } else {
            em.persist(athlete);
            processInfo = "The Athlete Added";
        }
        em.getTransaction().commit();

//        try {
//            em.persist(athlete);
//            em.getTransaction().commit();
//            processInfo = "The Athlete Added";
//        } catch (EntityExistsException ex) {
//            processInfo = "Athlete exists in our list, try again";
//        } finally {
//            closeConnection();
//        }
        closeConnection();
        return (processInfo);
    }

    public boolean checkIfNotExists(Athlete athlete) {
        boolean exist = false;
        EntityManager em = openConnection();
        List<Athlete> ath = em.createNamedQuery("Athlete.findIfExists", Athlete.class).setParameter("name", athlete.getName()).setParameter("height", athlete.getHeight()).
                setParameter("weight", athlete.getWeight()).setParameter("dob", athlete.getDob()).getResultList();
        if (ath.size() > 0) {
            exist = true;
        }
        return (exist);

    }
}
