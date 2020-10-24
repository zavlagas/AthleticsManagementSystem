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
import system.entities.Stadium;
import system.enums.LocationType;
import system.services.StadiumService;

/**
 *
 * @author User
 */
@WebServlet(name = "StadiumEditServlet", urlPatterns = {"/stadium/editStadium"})
public class StadiumEditServlet extends HttpServlet {

    StadiumService service = new StadiumService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Stadium stadium = service.fetchStadiumById(id);
        req.setAttribute("LocationType", LocationType.values());
        req.setAttribute("st", stadium);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/stadium/editForm.jsp");
        dispatcher.forward(req, resp);
    }

//            <form class="form" action="${pageContext.request.contextPath}/stadium/editStadium" method="POST">
//                <label for="st_edit_id">Id</label>
//                <input id="st_edit_id" type="number" value="${st.sid}" readonly name="id"/>
//                <label for="st_edit_name">Name</label>
//                <input id="st_edit_name" type="text" value="${st.name}" name="name"/>
//                <label for="st_edit_loc">Location</label>
//                <input id="st_edit_loc" type="text" value="${st.location}" name="location"/>
//                <input class="btn" type="submit" value="Submit"/>
//            </form>
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String location = req.getParameter("location");
        String processInfo = service.updateStadiumWith(id, name, location);
        req.setAttribute("message", processInfo);
        resp.sendRedirect(req.getContextPath() + "/stadium/list?message=" + processInfo);
    }

}
