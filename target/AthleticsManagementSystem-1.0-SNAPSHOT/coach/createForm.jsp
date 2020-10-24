<%-- 
    Document   : createForm
    Created on : 19 Οκτ 2020, 2:04:59 μμ
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../styling/styling.css" />
        <title>Create Coach</title>
    </head>
    <body>
        <jsp:include page="../header.jsp"/>
        <section class="container">
            <h2>Create Coach</h2>
            <form class="form" action="${pageContext.request.contextPath}/coach/create" method="POST">
                <label for="co_name">Enter Name</label>
                <input id="co_name" type="text" name="name"/>
                <label for="co_salary">Enter Salary</label>
                <input id="co_salary" step="0.010" min="500" max="9999999" type="number" name="salary"/>
                <input class="btn" type="submit" value="Submit"/>
            </form>
        </section>
        <jsp:include page="../footer.jsp"/>
    </body>
</html>
