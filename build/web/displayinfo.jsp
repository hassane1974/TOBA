<%-- 
    Document   : displayinfo
    Created on : Oct 24, 2016, 10:25:29 AM
    Author     : hassane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
       
         <p>Here is the information that you entered:</p>
  
    <label>Username:</label>
    <span>${Login.username}</span><br>
    <label>Password:</label>
    <span>${Login.password}</span><br>
    <form action="index.html" methode="post">
        <input type="return" value="return">
    </form>
    </body>
</html>
