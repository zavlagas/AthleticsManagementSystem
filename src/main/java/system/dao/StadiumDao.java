/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import system.entities.Stadium;

/**
 *
 * @author User
 */
public class StadiumDao extends SuperDaoManagerFactory {

    public List<Stadium> getStadiumsFromDatabase() {
        EntityManager em = openConnection();
        List<Stadium> stadiums = em.createNamedQuery("Stadium.findAll", Stadium.class).getResultList();
        closeAndClearConnection();
        return (stadiums);
    }

    public String insertStadiumToDatabase(Stadium stadium) {
        String processInfo = null;
        EntityManager em = openConnection();
        em.getTransaction().begin();
        boolean exist = checkIfNotExists(em, stadium);
        if (exist) {
            processInfo = "Stadium exists in our list, try again";
        } else {
            em.persist(stadium);
            processInfo = "The Stadium Added";
        }
        em.getTransaction().commit();
        closeAndClearConnection();
        return (processInfo);

    }

    public boolean checkIfNotExists(EntityManager em, Stadium stadium) {
        boolean exist = true;
        try {
            Stadium st = em.createNamedQuery("Stadium.findIfExists", Stadium.class).setParameter("name", stadium.getName()).setParameter("location", stadium.getLocation()).getSingleResult();
        } catch (NoResultException ex) {
            exist = false;
        } finally {
            return (exist);
        }

    }

    public Stadium fetchStadiumFromDatabaseBy(int stadiumId) {
        EntityManager em = openConnection();
        Stadium stadium = em.createNamedQuery("Stadium.findBySid", Stadium.class).setParameter("sid", stadiumId).getSingleResult();
        closeAndClearConnection();
        return (stadium);
    }

    public String updateStadiumToDatabase(Stadium stadium) {
        EntityManager em = openConnection();
        em.getTransaction().begin();
        Stadium st = em.merge(stadium);
        st.setName(stadium.getName());
        st.setLocation(stadium.getLocation());
        em.getTransaction().commit();
        closeAndClearConnection();
        return ("The Stadium Updated");
    }

    public String deleteStadiumFromDatabase(int stadiumId) {
        EntityManager em = openConnection();
        em.getTransaction().begin();
        em.remove(em.getReference(Stadium.class, stadiumId));
        em.getTransaction().commit();
        closeAndClearConnection();
        return ("The Stadium Deleted");
    }

}
