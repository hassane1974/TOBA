<%-- 
    Document   : Sucess
    Created on : Oct 25, 2016, 9:28:57 PM
    Author     : hassane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
<head>
<title>Account_created</title>
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
<h2>Account  Successfully Created</h2>
<img  src=" images/bank1.jpg" alt="bank" width="320" height="250">


  Congratulation Your Account was successfully created<br>
                     You can start using your Account<br>
        <br>
        <p>Here is the information that you entered:</p>
  
    <label>First Name:</label>
    <span>${Customer.firstName}</span>
    <label>Last Name:</label>
    <span>${Customer.lastName}</span><br>
    <label>  Email: </label>
    <spane>${Customer.email}</spane><br>
 
    
  <form action="index.html" method="get">
        <input type="hidden" name="action" value="join">
        <input type="submit" value="Return">
    </form>

 
  
</main>
<footer>Copyright &copy; 2016 Online Bank<br>
<a href="mailto:Hassane@khouni.com">Hassane@khouni.com</a>
</footer>
</div>
</body>
</html>