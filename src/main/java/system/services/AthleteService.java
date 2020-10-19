/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.services;


import java.sql.Date;
import java.util.List;
import system.dao.AthleteDao;
import system.entities.Athlete;

/**
 *
 * @author User
 */
public class AthleteService {

    AthleteDao athleteDao = new AthleteDao();

    public List<Athlete> getAllAthletes() {
        List<Athlete> athletes = athleteDao.getAthletesFromDatabase();
        return(athletes);
    }

    public String createAthleteIfNotExists(String name, String height, String weigth, String dob) {
        Athlete athlete = new Athlete(name,Double.parseDouble(height),Double.parseDouble(weigth),Date.valueOf(dob));
        String processInfo = athleteDao.insertAthleteToDatabase(athlete);
        return(processInfo);
    }

   

}
