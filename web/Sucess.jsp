<%-- 
    Document   : Sucess
    Created on : Oct 25, 2016, 9:28:57 PM
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
<h2>Account  Successfully Created</h2>
<img  src=" images/bank1.jpg" alt="bank" width="320" height="250">


  <div class="clear">Congratulation Your Account was successfully created<br>
                     You can start using your Account<br>
        <br>
        <p>Here is the information that you entered:</p>
   <label>Username:</label>
    <span>${user.userName}</span>&nbsp;&nbsp;&nbsp;&nbsp;
     <label>Password:</label>
    <span>${user.passWord}</span>&nbsp;&nbsp;&nbsp;&nbsp;
    <label>First Name:</label>
    <span>${user.firstName}</span>&nbsp;&nbsp;&nbsp;&nbsp;
     <label>City:</label>
    <span>${user.city}</span><br>
    <label>Last Name:</label>
    <span>${user.lastName}</span>&nbsp;&nbsp;&nbsp;&nbsp;
     <label>Phone number:</label>
    <span>${user.phone}</span><br>
   
     <label>Email:</label>
    <span>${user.email}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <label>Address:</label>
    <span>${user.address}</span><br>
     <label>State:</label>
    <span>${user.state}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <label>ZipCode:</label>
    <span>${user.zipcode}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    
  <br> 
 
  <form action="" method="get">
        <input type="hidden" name="action" value="join">
        <input type="submit" value="Return">
    </form>

 
  </div>
</main>
    <c:import url="/footer.jsp" />