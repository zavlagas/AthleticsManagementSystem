/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.servlet.stadium;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import system.entities.Stadium;
import system.services.StadiumService;

/**
 *
 * @author User
 */
@WebServlet(name = "StadiumServletList", urlPatterns = {"/stadium/list"})
public class StadiumServletList extends HttpServlet {

    StadiumService service = new StadiumService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Stadium> stadiums;
        stadiums = service.getAllStadiums();
        req.setAttribute("stadiums", stadiums);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/stadium/stadiumList.jsp");
        dispatcher.forward(req, resp);
    }

}
