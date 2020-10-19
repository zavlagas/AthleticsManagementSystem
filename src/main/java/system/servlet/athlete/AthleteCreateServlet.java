/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.servlet.athlete;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "AthleteCreateServlet", urlPatterns = {"/athlete/create"})
public class AthleteCreateServlet extends HttpServlet {

    AthleteService service = new AthleteService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/athlete/createForm.jsp");
        dispatcher.forward(req, resp);
    }

//    <form class="form" action="${pageContext.request.contextPath}/athlete/create" method="POST">
//                <label for="ath_name">Enter Name</label>
//                <input id="ath_name" type="text" name="name"/>
//                <label for="ath_age">Enter Age</label>
//                <input id="ath_age" min="1" max="40" type="number" name="age"/>
//                <label for="ath_height">Enter Height</label>
//                <input id="ath_height" step="any" min="1.40" max="2.30" type="number" name="height"/>
//                <label for="ath_weight">Enter Weight</label>
//                <input id="ath_weight" min="50" max="150" type="number" name="weight"/>
//                <label for="ath_dob">Enter Date Of Birth</label>
//                <input id="ath_dob" type="date" name="dob"/>
//                <input class="btn" type="submit" value="Submit"/>
//            </form>
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String height = req.getParameter("height");
        String weigth = req.getParameter("weight");
        String dob = req.getParameter("dob");
        String processInfo = service.createAthleteIfNotExists(name, height, weigth, dob);
        req.setAttribute("message", processInfo);
        resp.sendRedirect(req.getContextPath() + "/athlete/list?message=" + processInfo);

    }

}
