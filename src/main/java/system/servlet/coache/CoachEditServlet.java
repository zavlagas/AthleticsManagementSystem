/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.servlet.coache;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "CoachEditServlet", urlPatterns = {"/coach/editCoach"})
public class CoachEditServlet extends HttpServlet {

    CoachService service = new CoachService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Coach coach = service.fetchCoachBy(id);
        req.setAttribute("coach", coach);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/coach/editForm.jsp");
        dispatcher.forward(req, resp);
    }
//    
//            <form class="form" action="${pageContext.request.contextPath}/coach/editCoach" method="POST">
//                <label for="co_edit_id">Id</label>
//                <input id="co_edit_id" type="number" value="${coach.cid}" readonly name="id"/>
//                <label for="co_name">Name</label>
//                <input id="co_name" type="text" value="${coach.name}" name="name"/>
//                <label for="co_salary">Salary</label>
//                <input id="co_salary" min="500" type="number" value="${coach.salary}" name="salary"/>
//                <input class="btn" type="submit" value="Submit"/>
//            </form>

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String salary = req.getParameter("salary");

        String processInfo = service.updateCoachWith(id, name, salary);

        req.setAttribute("message", processInfo);

        resp.sendRedirect(req.getContextPath() + "/coach/list?message=" + processInfo);
    }

}
