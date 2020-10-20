/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import system.entities.Coach;
import system.services.CoachService;

/**
 *
 * @author User
 */
@WebServlet(name = "CoacheServletList", urlPatterns = {"/coach/list"})
public class CoacheServletList extends HttpServlet {

    CoachService service = new CoachService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Coach> coaches = new LinkedList();
        coaches = service.getAllCoaches();
        req.setAttribute("coaches", coaches);
        RequestDispatcher dispacher = req.getRequestDispatcher("/coach/coachList.jsp");
        dispacher.forward(req, resp);
    }

}
