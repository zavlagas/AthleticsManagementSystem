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
        return (athletes);
    }

    public String createAthleteIfNotExists(String name, String height, String weigth, String dob) {
        Athlete athlete = new Athlete(name, Double.parseDouble(height), Double.parseDouble(weigth), Date.valueOf(dob));
        String processInfo = athleteDao.insertAthleteToDatabase(athlete);
        return (processInfo);
    }

    public String deleteAthleteBy(String id) {
        int athleteId = Integer.parseInt(id);
        String processInfo = athleteDao.deleteAthleteToDatabaseBy(athleteId);
        return (processInfo);
    }

    public Athlete fetchAthleteBy(String id) {
        int athleteId = Integer.parseInt(id);
        Athlete ath = athleteDao.fetchAthleteFromDatabaseBy(athleteId);
        return (ath);
    }

    public String updateAthleteWith(String id, String name, String height, String weight, String date) {
        int athId = Integer.parseInt(id);
        double athHeight = Double.parseDouble(height);
        double athWeight = Double.parseDouble(weight);
        Date athDob = Date.valueOf(date);
        Athlete ath = new Athlete(athId, name, athHeight, athWeight, athDob);
        String processInfo = athleteDao.updateAthleteToDatabaseBy(ath);
        return(processInfo);

    }

}
