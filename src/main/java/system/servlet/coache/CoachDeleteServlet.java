/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.servlet.coache;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import system.services.CoachService;

/**
 *
 * @author User
 */
@WebServlet(name = "CoachDeleteServlet", urlPatterns = {"/coach/deleteCoach"})
public class CoachDeleteServlet extends HttpServlet {
    
    CoachService service = new CoachService();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String processInfo = service.deleteCoachBy(id);
        req.setAttribute("message", processInfo);
        resp.sendRedirect(req.getContextPath() + "/coach/list?message=" + processInfo);
    }
    
}
