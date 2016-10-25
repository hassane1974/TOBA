package toba;


import business.Login;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

        String url = "/Login.html";

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "Login";  // default action
        }

        // perform action and set URL to appropriate page
        if (action.equals("Login")) {
            url = "/Login.html";    // the "join" page
        }
        else if (action.equals("add")) {                
            // get parameters from the request
            String username = request.getParameter("Username");
            
            String password = request.getParameter("Password");
            

            // store data in User object and save User object in database
            Login login = new Login(username, password);
           
          
            // set User object in request object and set URL
            request.setAttribute("Login", login);
           // url = "/index.html";   // 
        
          if (username.equals("jsmith@toba.com")&& password.equals("letmein")){
              
              url = "/Account_activity.html";
          }
            else {
             
              url = "/Login_faillure.html";
              
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