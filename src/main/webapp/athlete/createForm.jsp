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
        <title>Create Athlete</title>
    </head>
    <body>
        <jsp:include page="../header.jsp"/>
        <section class="container">
            <h2>Create Athlete</h2>
            <form class="form" action="${pageContext.request.contextPath}/athlete/create" method="POST">
                <label for="ath_name">Enter Name</label>
                <input id="ath_name" type="text" name="name"/>
                <label for="ath_height">Enter Height</label>
                <input id="ath_height" step="0.01" min="1.30" max="2.50" type="number" name="height"/>
                <label for="ath_weight">Enter Weight</label>
                <input id="ath_weight" min="30" max="150" type="number" name="weight"/>
                <label for="ath_dob">Enter Date Of Birth</label>
                <input id="ath_dob" type="date" name="dob"/>
                <input class="btn" type="submit" value="Submit"/>
            </form>
        </section>

        <jsp:include page="../footer.jsp"/>
    </body>
</html>
