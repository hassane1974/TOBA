package toba;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import business.Customer;

@WebServlet(urlPatterns = {"/NewCustomerServlet"})
public class NewCustomerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/New_customer.html";
        
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // deault action
        }

        // perform action and set URL to appropriate page
        if (action.equals("join")) {
            url = "/Success.html";    // the "join" page
        } 
        else if (action.equals("add")) {
            // get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

            // store data in User object
            Customer customer = new Customer(firstName, lastName, email);

            // validate the parameters
            String message;
            if(firstName.equals(null)&& lastName.equals(null)&& email.equals(null)
                    
                &&firstName.isEmpty() && lastName.isEmpty() && email.isEmpty()) {
                message = "Please fill out all boxes";
                url = "/displayinfo.jsp";
            } 
            else {
                message = null;
                //url = "/thanks.jsp";
                //UserDB.insert(user);
            }
            request.setAttribute("Customer", customer);
            request.setAttribute("message", message);
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