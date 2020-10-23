/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.servlet.stadium;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import system.services.StadiumService;

/**
 *
 * @author User
 */
@WebServlet(name = "StadiumDeleteServlet", urlPatterns = {"/stadium/deleteStadium"})
public class StadiumDeleteServlet extends HttpServlet {
    
    StadiumService service = new StadiumService();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id = req.getParameter("id");
        String processInfo = service.deleteStadium(id);
        req.setAttribute("message", processInfo);
        resp.sendRedirect(req.getContextPath() + "/stadium/list?message=" + processInfo);
    }
    
}
