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
        <nav>
            <ul>
                <li id="logo"><a href="/WebServletJpa/index.jsp">Sales Company</a></li>
                <li id="product-li"><a href="/WebServletJpa/ListProductServlet">Products</a></li>
                <li id="customer-li"><a href="/WebServletJpa/ListCustomerServlet">Customers</a></li>
                <li id="salesman-li"><a href="/WebServletJpa/ListSalesmanServlet">Salesman</a></li>
                <li id="sales-li"><a href="/WebServletJpa/ListSalesServlet">Sales</a></li>
                <li id="logged-li"><a href="#">User: ${username}</a></li>
                <li id="logout-li"><a href="/WebServletJpa/LogoutServlet">Logout</a></li>
            </ul>
        </nav>
    </c:if> 
</header>