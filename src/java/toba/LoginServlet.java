package toba;

import business.Login;
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
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/Login.jsp";

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "Login";  // default action
        }

        // perform action and set URL to appropriate page
        if (action.equals("Login")) {
            url = "/Login.jsp";    // the "join" page
        } else if (action.equals("add")) {
            // get parameters from the request
            String username = request.getParameter("Username");

            String password = request.getParameter("Password");
             User user = new User();
            String message = null;
            if (username.equals("") || password.equals("")) {
                // forward to the view to get missing parameters
                message = "*********Please fill out all boxes**************";
                url = "/Login.jsp";}
            else{  
                message = "";       
            } 
             
 
            
            // store data in User object and save User object in database
            Login login = new Login(username, password);
             //User user;
            
             
            user = UserDB.selectUser(username,password);
            //session.setAttribute("user", user);
            // set User object in request object and set URL
            request.setAttribute("Login", login);
            request.setAttribute("message", message);
            // url = "/index.html";   // 
             
            
            if (UserDB.userExists(username,password))
                 //   && password.equals((UserDB.userExists(user.getPassWord()))))
            {
               
               HttpSession session = request.getSession();
               session.setAttribute("user", user);
                url = "/Account_activity.jsp";
            } else {
                
                url = "/displayinfo.jsp";

            }

        }

        // forward request and response objects to specified URL
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
