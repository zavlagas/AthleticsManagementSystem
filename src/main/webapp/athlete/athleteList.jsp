<%-- 
    Document   : athleteList
    Created on : 19 Οκτ 2020, 11:47:50 πμ
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../styling/styling.css" />
        <title>Athletes List</title>
    </head>
    <body>
        <jsp:include page="../header.jsp"/>
        <section class="container">
            <div class="btn-area">
                <a  class="btn" href="${pageContext.request.contextPath}/athlete/create">Create Athlete</a> 
            </div>
            <table class="table">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Height</th>
                        <th>Weight</th>
                        <th>Birth Date</th>
                        <th colspan="2">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="ath" items="${athletes}">
                        <tr>
                            <td>${ath.aid}</td>
                            <td>${ath.name}</td>
                            <td>${ath.height}</td>
                            <td>${ath.weight}</td>
                            <td>${ath.dob}</td>
                            <td class="buttontd"><a class="btn" href="${pageContext.request.contextPath}/athlete/editAthlete?id=${ath.aid}">Edit</a></td>
                            <td class="buttontd"><a class="btn" href="${pageContext.request.contextPath}/athlete/deleteAthlete?id=${ath.aid}">Delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
                <p class="msg">${param.message}</p>
        </section>
        <jsp:include page="../footer.jsp"/>
    </body>
</html>
