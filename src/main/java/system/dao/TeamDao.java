/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import system.entities.Team;

/**
 *
 * @author User
 */
public class TeamDao extends SuperDaoManagerFactory {

    public List<Team> findAllTeamsFromDatabase() {
        EntityManager em = openConnection();
        List<Team> teams = em.createNamedQuery("Team.findAll", Team.class).getResultList();
        closeAndClearConnection();
        return (teams);
    }

    public String insertTeamToDatabase(Team team) {
        String processInfo = null;
        EntityManager em = openConnection();
        em.getTransaction().begin();
        boolean exist = checkIfNotExists(em, team);
        if (exist) {
            processInfo = "Team exists in our list, try again";
        } else {
            em.persist(team);
            processInfo = "The Team Added";
        }
        em.getTransaction().commit();
        closeAndClearConnection();
        return (processInfo);

    }

    public boolean checkIfNotExists(EntityManager em, Team team) {
        boolean exist = true;
        try {
            Team t = em.createNamedQuery("Team.findIfExists", Team.class).setParameter("name", team.getName()).setParameter("sport", team.getSport()).getSingleResult();
        } catch (NoResultException ex) {
            exist = false;
        } finally {
            return (exist);
        }

    }

    public String deleteTeamFromDatabaseBy(int teamId) {
        EntityManager em = openConnection();
        em.getTransaction().begin();
        em.remove(em.getReference(Team.class,teamId));
        em.getTransaction().commit();
        closeAndClearConnection();
        return("The Team Deleted");
    }

}
