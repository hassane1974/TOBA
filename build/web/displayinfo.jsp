<%-- 
    Document   : displayinfo
    Created on : Oct 24, 2016, 10:25:29 AM
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
<h2>Account  Login Failure</h2>
<img  src=" images/bank1.jpg" alt="bank" width="320" height="250">


  <div class="clear">Sorry the information that you Entered doesn't match<br>
                     <br>
        <br>
<p>Here is the information that you entered:</p>
  
    <label>Username:</label>
    <span>${Login.username}</span><br>
    <label>Password:</label>
    <span>${Login.password}</span><br>
   
      
  </div>
 
</main>
<footer>Copyright &copy; 2016 Online Bank<br>
<a href="mailto:Hassane@khouni.com">Hassane@khouni.com</a>
</footer>
</div>
</body>
</html>
