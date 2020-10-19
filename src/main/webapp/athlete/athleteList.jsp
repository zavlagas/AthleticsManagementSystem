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
        <link rel="stylesheet" href="styling/styling.css" />
        <title>Athletes List</title>
    </head>
    <body>
        <jsp:include page="../header.jsp"/>
        <section class="container">
            <div class="btn-area">
                <a  class="btn" href="${pageContext.request.contextPath}/...here">Create Athlete</a> 
            </div>
            <table class="table">
                <thead>
                    <tr>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="" items="">
                        <tr>
                            <td></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </section>
        <jsp:include page="../footer.jsp"/>
    </body>
</html>
