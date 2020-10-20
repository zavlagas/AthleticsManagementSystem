/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.servlet.athlete;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import system.services.AthleteService;

/**
 *
 * @author User
 */
@WebServlet(name = "AthleteDeleteServlet", urlPatterns = {"/athlete/deleteAthlete"})
public class AthleteDeleteServlet extends HttpServlet {

    AthleteService service = new AthleteService();

//    href="${pageContext.request.contextPath}/athlete/deleteAthlete?id=${ath.aid}
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String processInfo = service.deleteAthleteBy(id);
        req.setAttribute("message", id);
        resp.sendRedirect(req.getContextPath() + "/athlete/list?message=" + processInfo);
    }

}
