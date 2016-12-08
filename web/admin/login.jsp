<%-- 
    Document   : login
    Created on : Nov 30, 2016, 3:00:29 PM
    Author     : hassane
--%>


<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/header.html" />
<!--<link rel="stylesheet" href="/styles/csstoba.css">-->
<div id="wrapper">
<header><h1>Titan Online Banking Application</h1></header>

<nav>
<ul>
 <li><a href="/index.jsp">Home</a></li>
 <li><a href="reports.jsp">Reports</a></li>
     
 </ul>
   
</nav>
<main>

  <h1>Admin Login Form</h1>
  <p>Please enter your username and password to continue.</p>
        <form action="j_security_check" method="get">
            <label class="pad_top">Username</label>
            <input type="text" name="j_username"><br>
            <label class="pad_top">Password</label>
            <input type="password" name="j_password"><br>
            <label>&nbsp;</label>
            <input type="submit" value="Login" class="margin_left">    
        </form>

  </div>
</main>

<c:import url="/footer.jsp" />

      