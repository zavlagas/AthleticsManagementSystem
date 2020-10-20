/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.servlet.coache;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "CoachCreateServlet", urlPatterns = {"/coach/create"})
public class CoachCreateServlet extends HttpServlet {
    
    CoachService service = new CoachService();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/coach/createForm.jsp");
        dispatcher.forward(req, resp);
    }

//    
//             <form class="form" action="${pageContext.request.contextPath}/coach/create" method="POST">
//                <label for="co_name">Enter Name</label>
//                <input id="co_name" type="text" name="name"/>
//                <label for="co_salary">Enter Salary</label>
//                <input id="co_salary" min="500" type="number" name="salary"/>
//                <input class="btn" type="submit" value="Submit"/>
//             </form>
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String salary = req.getParameter("salary");
        String processInfo = service.createCoachIfNotExists(name,salary);
        req.setAttribute("message", processInfo);
        resp.sendRedirect(req.getContextPath() + "/coach/list?message=" + processInfo);
    }
    
}
