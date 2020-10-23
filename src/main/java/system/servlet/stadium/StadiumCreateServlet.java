/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.servlet.stadium;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "StadiumCreateServlet", urlPatterns = {"/stadium/create"})
public class StadiumCreateServlet extends HttpServlet {
    
    StadiumService service = new StadiumService();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/stadium/createForm.jsp");
        dispatcher.forward(req, resp);
    }

//            <form class="form" action="${pageContext.request.contextPath}/stadium/create" method="POST">
//                <label for="st_name">Enter Name</label>
//                <input id="st_name" type="text" name="name"/>
//                <label for="st_loc">Enter Location</label>
//                <input id="st_loc" type="text" name="location"/>
//                <input class="btn" type="submit" value="Submit"/>
//            </form>
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String location = req.getParameter("location");
        String processInfo = service.createStadiumIfNotExists(name, location);
        req.setAttribute("message", processInfo);
        resp.sendRedirect(req.getContextPath() + "/stadium/list?message=" + processInfo);
    }
    
}
