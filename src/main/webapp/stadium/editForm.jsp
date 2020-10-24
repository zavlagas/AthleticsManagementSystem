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
        <title>Edit Stadium</title>
    </head>
    <body>
        <jsp:include page="../header.jsp"/>
        <section class="container">
            <h2>Edit Stadium</h2>
            <form class="form" action="${pageContext.request.contextPath}/stadium/editStadium" method="POST">
                <label for="st_edit_id">Id</label>
                <input id="st_edit_id" type="number" value="${st.sid}" readonly name="id"/>
                <label for="st_edit_name">Name</label>
                <input id="st_edit_name" type="text" value="${st.name}" name="name"/>
                <label for="st_edit_loc">Location</label>
                <select name="location" id="st_edit_loc" >
                    <c:forEach var="loc" items="${LocationType}">
                        <option value="${loc}" ${st.location == loc?'selected':''}>${loc}</option>
                    </c:forEach>
                </select>
                <input class="btn" type="submit" value="Submit"/>
            </form>
        </section>
        <jsp:include page="../footer.jsp"/>
    </body>
</html>
