<%-- 
    Document   : transfert
    Created on : Nov 21, 2016, 3:45:27 PM
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
      <li><a href="transfer.jsp">Transfer Funds</a></li>
 </ul>
   
</nav>
<main>
   
<h2>Transfer Funds</h2> 
<h4><i> ${message1}</i></h4>
 <p>Checking account balance: ${user.getCheckingBalance()}</p>
  <p>Savings account balance: ${user. getSavingsBalance()}</p>
 <form action="TransactionServlet" method="post">
      <label class="pad_top">Specify Amount to Transfer:</label>
        <input type="text" name="amount" required><br>
        <input type="submit" value="submit Transfer" class="margin_left">
      
 </form>
 
  <br> 
  
  <br>
  <br>
 
</main>
<c:import url="/footer.jsp" />

