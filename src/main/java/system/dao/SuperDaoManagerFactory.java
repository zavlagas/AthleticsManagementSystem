/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.dao;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author User
 */
public class SuperDaoManagerFactory {

    protected static EntityManagerFactory emf;
    private EntityManager em;

    protected static void openEntityManagerFactory() {
        SuperDaoManagerFactory.emf = Persistence.createEntityManagerFactory("amsPU");
    }

    protected static void closeEntityManagerFactory() {

        SuperDaoManagerFactory.emf.close();
    }

    private EntityManager getEntityManager() {
        em = emf.createEntityManager();

        return (em);
    }

    private void closeEntityManager() {
        em.close();
    }

    protected EntityManager openConnection() {
        EntityManager em1 = getEntityManager();
        return (em1);
    }

    protected void closeAndClearConnection() {
        em.clear();
        em.close();
    }

    

    

    
    
    

}
