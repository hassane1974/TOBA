<%-- 
    Document   : Login
    Created on : Nov 5, 2016, 2:03:33 PM
    Author     : hassane
--%>


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
      <li><a href="transfer.jsp">Transfer</a></li>
 </ul>
   
</nav>
<main>
<h2>Login</h2>
<h4> <i>${message}</i></h4>
 <form action="LoginServlet" method="post">
        <input type="hidden" name="action" value="add">        
        <label>Username:</label>
        <input type="text" name="Username" required><br>
        <label>Password:</label>
        <input type="text" name="Password" required><br>
        <label>&nbsp;</label>
               
        
        <input type="submit" value="Login" id="submit">
 </form>

    <form action="New_customer.jsp" method="post">
     <input type="submit" value="New Customer Registration" >
    </form><br>
 <form action="password_reset.jsp" method="post">
     <input type="submit" value="Reset Password" >
    </form>

  <br> 
  
  <br>
  <br>
 
</main>
<c:import url="/footer.jsp" />