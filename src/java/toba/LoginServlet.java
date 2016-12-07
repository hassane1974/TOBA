package toba;

import business.Account;
import business.Login;
import business.PasswordUtil;
import business.User;
import data.AccountDB;
import data.UserDB;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
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
            User user = UserDB.selectUser(username);
            Account account = new Account();
            String message = null;
            if (username.equals("") || password.equals("")) {
                // forward to the view to get missing parameters
                message = "*********Please fill out all boxes**************";
                url = "/Login.jsp";
            } else {
                message = "";
            }

            // store data in User object and save User object in database
            Login login = new Login(username, password);
            HttpSession session = request.getSession();

            String salt = "";
            String saltedAndHashedPassword;
            try {
            
                salt = user.getSalt();
                saltedAndHashedPassword = PasswordUtil.hashPassword(password + salt);                    
        } catch (NoSuchAlgorithmException ex) {
            saltedAndHashedPassword = ex.getMessage();
        }
            
            session.setAttribute("user", user);
            //set User object in request object and set URL
            request.setAttribute("Login", login);
            request.setAttribute("message", message);
            // url = "/index.html";   // 

            if (user.getPassWord().equals(saltedAndHashedPassword)) {

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
