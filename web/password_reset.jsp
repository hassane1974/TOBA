<%-- 
    Document   : password_reset
    Created on : Nov 7, 2016, 1:41:08 PM
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
            <li><a href="admin/reports.jsp">Reports</a></li>
            <li><a href="Login.jsp">Login</a></li>
            <li><a href="Account_activity.jsp">Account activity</a></li>
            <li><a href="Transaction.jsp">Transaction</a></li>
            <li><a href="transfer.jsp">Transfer</a></li>
        </ul>

    </nav>
    <main>
        <h2>Password Reset</h2>
        <img  src=" images/bank1.jpg" alt="bank" width="320" height="250">
        <br>

<p><i>${message}</i></p>
        <form action="PasswordChangeServlet" method="post">
            <label>Username:</label>
            <span>${user.userName}</span><br>
            <label class="pad_top">Password:</label>
    <input type="text" name="NewPassword" value="${user.passWord}"><br>
           <%-- <label>Password:</label>
            <span><%= user.getPassWord()%></span><br> 
            <label>New Password:</label> 
            <input type="text" name="NewPassword" required> --%>

            <input type="submit" value="Change" id="submit">
        </form>
 
    </main>


    <c:import url="/footer.jsp" />