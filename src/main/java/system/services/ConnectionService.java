/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.services;

import system.dao.ConnectionDao;



/**
 *
 * @author User
 */
public class ConnectionService {

    ConnectionDao conn = new ConnectionDao();

    public void openManagerFactoryConnection() {
        conn.openManagerFactoryConnection();
    }

    public void closeManagerFactoryConnection() {
        conn.closeManagerFactoryConnection();
    }

}
