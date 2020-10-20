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
import system.entities.Athlete;
import system.services.AthleteService;

/**
 *
 * @author User
 */
@WebServlet(name = "AthleteEditServlet", urlPatterns = {"/athlete/editAthlete"})
public class AthleteEditServlet extends HttpServlet {
    
    AthleteService service = new AthleteService();
//    href="${pageContext.request.contextPath}/athlete/editAthlete?id=${ath.aid}"

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Athlete athlete = service.fetchAthleteBy(id);
        req.setAttribute("ath", athlete);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/athlete/editForm.jsp");
        dispatcher.forward(req, resp);
    }

//                <form class="form" action="${pageContext.request.contextPath}/athlete/editAthlete" method="POST">
//                <label for="ath_edit_id">Id</label>
//                <input id="ath_edit_id" type="number" value="${ath.aid}" readonly name="id"/>
//                <label for="ath_edit_name">Name</label>
//                <input id="ath_edit_name" type="text" value="${ath.name}" name="name"/>
//                <label for="ath_edit_height">Height</label>
//                <input id="ath_edit_height" step="0.01" min="1.30" value="${ath.height}" max="2.50" type="number" name="height"/>
//                <label for="ath_edit_weight">Weight</label>
//                <input id="ath_edit_weight" min="30" max="150" value="${ath.weight}"type="number" name="weight"/>
//                <label for="ath_edit_dob">Date Of Birth</label>
//                <input id="ath_edit_dob" type="date" value="${ath.dob}" name="dob"/>
//                <input class="btn" type="submit" value="Submit"/>
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String height = req.getParameter("height");
        String weight = req.getParameter("weight");
        String date = req.getParameter("dob");
        String processInfo = service.updateAthleteWith(id, name, height, weight, date);
        resp.sendRedirect(req.getContextPath() + "/athlete/list?message=" + processInfo);
        
    }
    
}
