/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.servlet.team;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import system.enums.TeamSportType;
import system.services.TeamService;

/**
 *
 * @author User
 */
@WebServlet(name = "TeamCreateServlet", urlPatterns = {"/team/create"})
public class TeamCreateServlet extends HttpServlet {
    
    TeamService service = new TeamService();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("SportType", TeamSportType.values());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/team/createForm.jsp");
        dispatcher.forward(req, resp);
    }

//            <form class="form" action="${pageContext.request.contextPath}/team/create" method="POST">
//                <label for="team_name">Enter Name</label>
//                <input id="team_name" type="text" name="name"/>
//                <label for="team_sport">Enter Sport</label>
//                <select name="sport" id="team_sport">
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String sport = req.getParameter("sport");
        String processInfo = service.createTeamIfNotExists(name, sport);
        req.setAttribute("message", processInfo);
        resp.sendRedirect(req.getContextPath() + "/team/list?message=" + processInfo);
        
    }
    
}
