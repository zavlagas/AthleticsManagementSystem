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
        <title>stadium List</title>
    </head>
    <body>
        <jsp:include page="../header.jsp"/>
        <section class="container">
            <div class="btn-area">
                <a  class="btn" href="${pageContext.request.contextPath}/stadium/create">Create Stadium</a> 
            </div>
            <table class="table">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Location</th>
                        <th colspan="2">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="st" items="${stadiums}">
                        <tr>
                            <td>${st.sid}</td>
                            <td>${st.name}</td>
                            <td>${st.location}</td>
                            <td class="buttontd"><a class="btn" href="${pageContext.request.contextPath}/stadium/editStadium?id=${st.sid}">Edit</a></td>
                            <td class="buttontd"><a class="btn" href="${pageContext.request.contextPath}/stadium/deleteStadium?id=${st.sid}">Delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <p class="msg">${param.message}</p>
        </section>
        <jsp:include page="../footer.jsp"/>
    </body>
</html>
