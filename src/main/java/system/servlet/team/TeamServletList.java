package system.servlet.team;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import system.entities.Team;
import system.services.TeamService;

@WebServlet(name = "TeamServletList", urlPatterns = {"/team/list"})
public class TeamServletList extends HttpServlet {

    TeamService service = new TeamService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Team> teams = service.findAllTeams();
        req.setAttribute("teams", teams);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/team/teamList.jsp");
        dispatcher.forward(req, resp);
    }

}
