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
        <nav >
            <ul>
                <li><a id="logo" href="/AthleticsManagementSystem/index.jsp">Athletics Management System</a></li>
                <li><a id="athletes-li" href="/AthleticsManagementSystem/athlete/list">Athletes</a></li>
                <li><a id="coaches-li" href="/AthleticsManagementSystem/coach/list">Coaches</a></li>
                <li><a id="team-li" href="/AthleticsManagementSystem/team/list">Teams</a></li>
                <li><a id="stadium-li" href="/AthleticsManagementSystem/stadium/list">Stadiums</a></li>
                <li><a id="logged-li" href="#">User: ${username}</a></li>
                <li><a id="logout-li" href="/AthleticsManagementSystem/LogoutServlet">Logout</a></li>
            </ul>
        </nav>
    </c:if> 
</header>