<%-- 
    Document   : teamList
    Created on : 24 Οκτ 2020, 2:30:14 μμ
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../styling/styling.css" />
        <title>Team List</title>
    </head>
    <body>
        <jsp:include page="../header.jsp"/>
        <section class="container">
            <div class="btn-area">
                <a  class="btn" href="${pageContext.request.contextPath}/team/create">Create Team</a> 
            </div>
            <table class="table">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Sport</th>
                        <th colspan="2">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="team" items="${teams}">
                        <tr>
                            <td>${team.tid}</td>
                            <td>${team.name}</td>
                            <td>${team.sport}</td>
                            <td class="buttontd"><a class="btn" href="${pageContext.request.contextPath}/team/editTeam?id=${team.tid}">Edit</a></td>
                            <td class="buttontd"><a class="btn" href="${pageContext.request.contextPath}/team/deleteTeam?id=${team.tid}">Delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <p class="msg">${param.message}</p>
        </section>
        <jsp:include page="../footer.jsp"/>
    </body>
</html>
