/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toba;

import business.User;
import data.UserDB;
import java.io.IOException;
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
            UserDB.update(user);
            // set User object in request object and set URL

            //request.setAttribute("message", message);
            // url = "/index.html";   //
            request.setAttribute("user", user);
    
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
