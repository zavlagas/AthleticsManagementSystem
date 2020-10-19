<%-- 
    Document   : header
    Created on : 8 Οκτ 2020, 8:10:03 μμ
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<header>
    <c:if test="${username != null}">
        <nav>
            <ul>
                <li id="logo"><a href="/WebServletJpa/index.jsp">Athletics Management System</a></li>
                <li id="athletes-li"><a href="/WebServletJpa/ListProductServlet">Athletes</a></li>
                <li id="coaches-li"><a href="/WebServletJpa/ListCustomerServlet">Coaches</a></li>
                <li id="team-li"><a href="/WebServletJpa/ListSalesmanServlet">Teams</a></li>
                <li id="stadium-li"><a href="/WebServletJpa/ListSalesServlet">Stadiums</a></li>
                <li id="logged-li"><a href="#">User: ${username}</a></li>
                <li id="logout-li"><a href="/WebServletJpa/LogoutServlet">Logout</a></li>
            </ul>
        </nav>
    </c:if> 
</header>