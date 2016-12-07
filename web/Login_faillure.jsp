<%-- 
    Document   : Login_faillure
    Created on : Nov 5, 2016, 2:04:10 PM
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
 <li><a href="admin/reports.jsp">Reports</a></li>
      <li><a href="Login.jsp">Login</a></li>
      <li><a href="Account_activity.jsp">Account activity</a></li>
      <li><a href="Transaction.jsp">Transaction</a></li>
      <li><a href="transfer.jsp">Transfer</a></li>
 </ul>
   
</nav>
<main>
<h2>Account  Login Failure</h2>
<img  src=" images/bank1.jpg" alt="bank" width="320" height="250">


  <div class="clear">Sorry the information that you Entered doesn't match<br>
                     <br>
        <br>
<p>Here is the information that you entered:</p>
  
    <label>Username:</label>
    <span>${username}</span><br>
    <label>Password:</label>
    <span>${password}</span><br>
   
      
  </div>
 
</main>
    <c:import url="/footer.jsp" />