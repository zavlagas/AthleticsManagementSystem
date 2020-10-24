/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.services;

import java.util.List;
import system.dao.StadiumDao;
import system.entities.Stadium;
import system.enums.LocationType;

/**
 *
 * @author User
 */
public class StadiumService {

    StadiumDao sdao = new StadiumDao();

    public List<Stadium> getAllStadiums() {
        List<Stadium> stadiums;
        stadiums = sdao.getStadiumsFromDatabase();
        return (stadiums);
    }

    public String createStadiumIfNotExists(String name, String location) {
        LocationType lType = Enum.valueOf(LocationType.class, location);
        Stadium stadium = new Stadium(name, lType);
        String processInfo = sdao.insertStadiumToDatabase(stadium);
        return (processInfo);
    }

    public Stadium fetchStadiumById(String id) {
        int stadiumId = Integer.parseInt(id);
        Stadium stadium = sdao.fetchStadiumFromDatabaseBy(stadiumId);
        return (stadium);
    }

    public String updateStadiumWith(String id, String name, String location) {
        LocationType lType = Enum.valueOf(LocationType.class, location);
        int stadiumId = Integer.parseInt(id);
        String processInfo = sdao.updateStadiumToDatabase(new Stadium(stadiumId, name, lType));
        return (processInfo);
    }

    public String deleteStadium(String id) {
        int stadiumId = Integer.parseInt(id);
        String processInfo = sdao.deleteStadiumFromDatabase(stadiumId);
        return (processInfo);
    }

}
