<%-- 
    Document   : reports
    Created on : Nov 30, 2016, 3:02:14 PM
    Author     : hassane
--%>


<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/header.html" />
<link rel="stylesheet" href="/styles/csstoba.css">
<div id="wrapper">
<header><h1>Titan Online Banking Application</h1></header>

<nav>
<ul>
 <li><a href="../index.jsp">Home</a></li>
 <li><a href="reports.jsp">Reports</a></li>
     
 </ul>
   
</nav>

<main>

  <h1>Reports</h1>
  
     
     <div class="clear">
            <table>
                <td>First Name</td> 
                <td>Last Name</td>
                <td>Phone</td>
                <td>Address</td>
                <td>City</td>
                <td>State</td>
                <!--&AElig;&nbsp;&nbsp;&nbsp;&nbsp;Last Name &nbsp;&nbsp;&nbsp;&nbsp;Phone&nbsp;&nbsp;&nbsp;Address</td>-->
        <jsp:include page="/ReportsServlet"/>
        <c:forEach var="u" items="${users}">
            
        <tr> 
            <td>${u.firstName}</td>
            <td>${u.lastName}</td>
            <td>${u.phone}</td>
            <td>${u.address}</td>
            <td>${u.city}</td>
            <td>${u.state}</td>
        </tr>
        </c:forEach> 
            </table>
           
  <br> 
    <p><a href="/userTableSpreadsheet">Return as an XLS file</a></p>
        <p><a href="../userTableGZIP">Return using GZIP compression</a></p>
  <br>
  <br>
  </div> 
      
      
      
     
  </div>

</main>

<c:import url="/footer.jsp" />