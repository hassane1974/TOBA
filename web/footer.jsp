<%-- 
    Document   : footer
    Created on : Nov 1, 2016, 2:29:09 PM
    Author     : hassane
--%>

<%@page import="java.util.Date"%>
<%@page import ="java.util.GregorianCalendar, java.util.Calendar"%>
 
<% 
      GregorianCalendar currentDate = new GregorianCalendar();
      Date current = new Date();
      int currentYear = currentDate.get(Calendar.YEAR);
%>
<footer>Copyright &copy; <%=currentYear%> Online Bank<br>
<a href="mailto:Hassane@khouni.com">Hassane@khouni.com</a>
<p>The current date is <%=current%> </p>
</footer>
</div>
</body>
</html
