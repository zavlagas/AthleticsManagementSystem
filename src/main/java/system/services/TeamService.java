/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.services;

import java.util.List;
import system.dao.TeamDao;
import system.entities.Team;
import system.enums.TeamSportType;

/**
 *
 * @author User
 */
public class TeamService {

    TeamDao tdao = new TeamDao();

    public List<Team> findAllTeams() {
        List<Team> teams = tdao.findAllTeamsFromDatabase();
        return (teams);
    }

    public String createTeamIfNotExists(String name, String sport) {
       TeamSportType type = Enum.valueOf(TeamSportType.class, sport);
       Team team = new Team(name, type);
       String processInfo = tdao.insertTeamToDatabase(team);
       return(processInfo);
    }

    public String deleteTeamFromDatabase(String id) {
      int teamId = Integer.parseInt(id);
      String processInfo = tdao.deleteTeamFromDatabaseBy(teamId);
      return(processInfo);
    }

}
