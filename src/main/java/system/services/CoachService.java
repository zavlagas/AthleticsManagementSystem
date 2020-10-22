/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.services;

import java.util.List;
import system.dao.CoachDao;
import system.entities.Coach;

/**
 *
 * @author User
 */
public class CoachService {

    CoachDao cdao = new CoachDao();

    public List<Coach> getAllCoaches() {
        List<Coach> coaches = cdao.getCoachesFromDatabase();
        return (coaches);
    }

    public String createCoachIfNotExists(String name, String salary) {
        Coach coach = new Coach(name, Double.parseDouble(salary));
        String processInfo = cdao.insertCoachToDatabase(coach);
        return (processInfo);
    }

    public String deleteCoachBy(String id) {
        int coachId = Integer.parseInt(id);
        String processInfo = cdao.deleteCoachToDatabaseBy(coachId);
        return (processInfo);
    }

    public Coach fetchCoachBy(String id) {
        int coachId = Integer.parseInt(id);
        Coach coach = cdao.fetchCoachFromDatabaseBy(coachId);
        return (coach);
    }

    public String updateCoachWith(String id, String name, String salary) {
        int coachId = Integer.parseInt(id);
        double coachSalary = Double.parseDouble(salary);
        Coach coach = new Coach(coachId, name, coachSalary);
        String processInfo = cdao.updateCoachToDatabase(coach);
        return (processInfo);
    }

}
