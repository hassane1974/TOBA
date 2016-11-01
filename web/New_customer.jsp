<%-- 
    Document   : New_customer
    Created on : Oct 31, 2016, 12:30:50 PM
    Author     : hassane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
<head>
<title>New_customer</title>
<meta charset="utf-8">
<link rel="stylesheet" href="styles/csstoba.css">
</head>
<body>
<div id="wrapper">
<header><h1>Titan Online Banking Application</h1></header>

<nav>
<ul>
 <li><a href="index.html">Home</a></li>
      <li><a href="Login.html">Login</a></li>
      <li><a href="Account_activity.html">Account activity</a></li>
      <li><a href="Transaction.html">Transaction</a></li>
      <li><a href="contact.html">Contact</a></li>
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
<footer>Copyright &copy; 2016 Online Bank<br>
<a href="mailto:Hassane@khouni.com">Hassane@khouni.com</a>
</footer>
</div>
</body>
</html>
