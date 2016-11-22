<%-- 
    Document   : New_customer
    Created on : Oct 31, 2016, 12:30:50 PM
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
<h2>New Customer LogIn</h2>
<p></p>
<p>Required information is marked with an asterisk(*).</p>

<h4> <i>${message}</i></h4>

    
<form action="NewCustomerServlet" method="post">
        <input type="hidden" name="action" value="add">       
    
       
        <label class="pad_top">*First Name:</label>
        <input type="text" name="firstName" >
        <label class="pad_top">*Last Name:</label>
        <input type="text" name="lastName" >
        <label class="pad_top">*Email:</label>
        <input type="email" name="email" >
         <label class="pad_top">*Phone:</label>
        <input type="text" name="Phone" >
         <label class="pad_top">*Address:</label>
        <input type="text" name="Address" >
       
        <label class="pad_top">*City:</label>
        <input type="text" name="City" >
        <label class="pad_top">*State:</label>
        <input type="text" name="State" >
        <label class="pad_top">*ZipCode:</label>
        <input type="text" name="Zipcode" >
        <label>&nbsp;</label>
 <input type="submit" value="creat new customer" class="margin_left">
 
</form>      
    
       
       
         
     
</main>
<c:import url="/footer.jsp" />