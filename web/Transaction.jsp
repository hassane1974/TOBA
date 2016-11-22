<%-- 
    Document   : Transaction
    Created on : Nov 5, 2016, 2:04:38 PM
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
<h2>Transactions</h2>
<%--<img  src=" images/bank1.jpg" alt="bank" width="320" height="250">

--%>
  <div class="clear"><br>
        <h2>Checking Account:</h2>
            <table>
        <c:forEach var="t" items="${checking.transactions}">
        <tr>
            <td>${t.startingBal}</td>
            <td>${t.finalBalance}</td>
            <td>${t.amountTransferred}</td>
            <td>${t.function}</td>
        </tr>
        </c:forEach> 
            </table>
             <h2>Savings Account:</h2>
            <table>
        <c:forEach var="t" items="${savings.transactions}">
        <tr>
            <td>${t.startingBal}</td>
            <td>${t.finalBalance}</td>
            <td>${t.amountTransferred}</td>
            <td>${t.function}</td>
        </tr>
        </c:forEach> 
            </table> 
  <br> 
  
  <br>
  <br>
  </div>
</main>
<c:import url="/footer.jsp" />