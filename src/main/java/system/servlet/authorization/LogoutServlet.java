/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.servlet.authorization;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import system.services.ConnectionService;


/**
 *
 * @author User
 */
@WebServlet(name = "LogoutServlet", urlPatterns = {"/LogoutServlet"})
public class LogoutServlet extends HttpServlet {
    ConnectionService service = new ConnectionService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service.closeManagerFactoryConnection();
        HttpSession session = req.getSession();
        session.invalidate(); 
//        session.removeAttribute("username"); 
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath+"/login.jsp");
    }
    
    
    
}
