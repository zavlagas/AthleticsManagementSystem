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
                <li id="logo"><a href="/AthleticsManagementSystem/index.jsp">Athletics Management System</a></li>
                <li id="athletes-li"><a href="/AthleticsManagementSystem/athlete/list">Athletes</a></li>
                <li id="coaches-li"><a href="/AthleticsManagementSystem/coach/list">Coaches</a></li>
                <li id="team-li"><a href="/AthleticsManagementSystem/team/list">Teams</a></li>
                <li id="stadium-li"><a href="/AthleticsManagementSystem/stadium/list">Stadiums</a></li>
                <li id="logged-li"><a href="#">User: ${username}</a></li>
                <li id="logout-li"><a href="/AthleticsManagementSystem/LogoutServlet">Logout</a></li>
            </ul>
        </nav>
    </c:if> 
</header>