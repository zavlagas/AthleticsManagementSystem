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
        <title>Edit Athlete</title>
    </head>
    <body>
        <jsp:include page="../header.jsp"/>
        <section class="container">
            <h2>Create Athlete</h2>
            <form class="form" action="${pageContext.request.contextPath}/athlete/editAthlete" method="POST">
                <label for="ath_edit_id">Id</label>
                <input id="ath_edit_id" type="number" value="${ath.aid}" readonly name="id"/>
                <label for="ath_edit_name">Name</label>
                <input id="ath_edit_name" type="text" value="${ath.name}" name="name"/>
                <label for="ath_edit_height">Height</label>
                <input id="ath_edit_height" step="0.01" min="1.30" value="${ath.height}" max="2.50" type="number" name="height"/>
                <label for="ath_edit_weight">Weight</label>
                <input id="ath_edit_weight" min="30" max="150" value="${ath.weight}"type="number" name="weight"/>
                <label for="ath_edit_dob">Date Of Birth</label>
                <input id="ath_edit_dob" type="date" value="${ath.dob}" name="dob"/>
                <input class="btn" type="submit" value="Submit"/>
            </form>
        </section>

        <jsp:include page="../footer.jsp"/>
    </body>
</html>
