<%-- 
    Document   : createForm
    Created on : 19 Οκτ 2020, 2:04:59 μμ
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../styling/styling.css" />
        <title>Create Stadium</title>
    </head>
    <body>
        <jsp:include page="../header.jsp"/>
        <section class="container">
            <h2>Create Stadium</h2>
            <form class="form" action="${pageContext.request.contextPath}/stadium/create" method="POST">
                <label for="st_name">Enter Name</label>
                <input id="st_name" type="text" name="name"/>
                <label for="st_loc">Enter Location</label>
                <select name="location" id="st_loc" title="Location">
                    <option value="none" selected disabled hidden> 
                        SELECT AN OPTION
                    </option> 
                    <c:forEach var="loc" items="${LocationType}">
                        <option value="${loc}">${loc}</option>
                    </c:forEach>
                </select>
                <input class="btn" type="submit" value="Submit"/>
            </form>
        </section>
        <jsp:include page="../footer.jsp"/>
    </body>
</html>
