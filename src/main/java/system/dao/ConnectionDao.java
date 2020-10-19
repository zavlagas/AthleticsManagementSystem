/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.dao;

/**
 *
 * @author User
 */
public class ConnectionDao extends SuperDaoManagerFactory{

    public void openManagerFactoryConnection() {
        openEntityManagerFactory();
    }

    public void closeManagerFactoryConnection() {
       closeEntityManagerFactory();
    }
}
