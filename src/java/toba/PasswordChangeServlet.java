/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toba;

import business.PasswordUtil;
import business.User;
import data.UserDB;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hassane
 */
@WebServlet(name = "PasswordChangeServlet_1", urlPatterns = {"/PasswordChangeServlet_1"})
public class PasswordChangeServlet extends HttpServlet {

    private String s;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/password_reset.jsp";

        // get current action
        // get parameters from the request
        String Npassword = request.getParameter("NewPassword");

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        // store data in User object and save User object in database
       

    if (user == null) {
         url ="/New_customer.jsp";
      
    }else {
            s = Npassword;
            user.passWord = s;
           
            session.setAttribute("user", user);
            request.setAttribute("s", s); 
            
            
            /*==========================================================*/
              String message;
        
            try {
            PasswordUtil.checkPasswordStrength(s);
            message = "";
        } catch (Exception e) {
            message = e.getMessage();
        }
        request.setAttribute("message", message);        
        
        // hash and salt password
        String hashedPassword;
        String salt = "";
        String saltedAndHashedPassword;
        try {
            
            salt = PasswordUtil.getSalt();
            saltedAndHashedPassword = PasswordUtil.hashPassword(s + salt);                    
            user.setPassWord(saltedAndHashedPassword);
            user.setSalt(salt);
        } catch (NoSuchAlgorithmException ex) {
            hashedPassword = ex.getMessage();
            saltedAndHashedPassword = ex.getMessage();
        }
      
            
            
            
           /*          =================================== */
            
            UserDB.update(user);
            // set User object in request object and set URL

            //request.setAttribute("message", message);
            // url = "/index.html";   //
            request.setAttribute("user", user);
            session.setAttribute("user", user);
            
            request.setAttribute("message", message);
            session.setAttribute("s", s);
            Date currentDate = new Date();
            request.setAttribute("currentDate", currentDate);
  
           // session.setAttribute("hashedPassword", hashedPassword);
        session.setAttribute("salt", salt);
        session.setAttribute("saltedAndHashedPassword", saltedAndHashedPassword);
    
            url = "/Account_activity.jsp";
            // forward request and response objects to specified URL
           
    }
     getServletContext()
                    .getRequestDispatcher(url)
                    .forward(request, response);
    }
 
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
