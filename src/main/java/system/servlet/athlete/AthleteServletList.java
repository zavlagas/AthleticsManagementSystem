/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.servlet.athlete;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import system.entities.Athlete;
import system.services.AthleteService;

/**
 *
 * @author User
 */
@WebServlet(name = "AthleteServletList", urlPatterns = {"/athlete/list"})
public class AthleteServletList extends HttpServlet {
    
    AthleteService service = new AthleteService();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        List<Athlete> athletes = new LinkedList<>();
        athletes = service.getAllAthletes();
        req.setAttribute("athletes", athletes);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/athlete/athleteList.jsp");
        dispatcher.forward(req, resp);
    }

}
