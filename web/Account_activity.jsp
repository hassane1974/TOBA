<%-- 
    Document   : Account_activity
    Created on : Nov 5, 2016, 2:02:46 PM
    Author     : hassane
--%>


<%@page import="business.User"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/header.html" />


<div id="wrapper">
    <header><h1>Titan Online Banking Application</h1></header>

    <nav>
        <ul>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="Login.jsp">Login</a></li>
            <li><a href="Account_activity.jsp">Account activity</a></li>
            <li><a href="Transaction.jsp">Transaction</a></li>
            <li><a href="contact.html">Contact</a></li>
        </ul>

    </nav>
    <main>
        <h2>Account Activity</h2>
        <img  src=" images/bank1.jpg" alt="bank" width="320" height="250">


        <div class="clear"> <br>




        </div>

        <%
            User user = (User) session.getAttribute("user");
        %>
        <%-- <c:set target="${user}"property="firstName" /> --%>
        <c:if test="${user == null}">
            <p> Not Logged In</P>
            </c:if> 
        <p>Welcome to TOBA Online banking </p>
        <label>First Name:</label>
        <span>${user.firstName}</span>&nbsp;&nbsp;&nbsp;&nbsp;

        <label>Last Name:</label>
        <span>${user.lastName}</span>&nbsp;&nbsp;&nbsp;&nbsp;


</div>               

</main>
<c:import url="/footer.jsp" />