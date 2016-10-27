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
        String url = "/Sucess.jsp";
      
 
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "New_customer.html";  // default action
        }

        if (action.equals("Submit")) {   
              String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
             String  Phone = request.getParameter("Phone");
            String  Address= request.getParameter("Address");
            String  City = request.getParameter("City");
             String State = request.getParameter("State");
            String Zipcode = request.getParameter("Zipcode");
            

            // store data in User object
          
            Customer customer = new Customer(firstName, lastName, email,Phone , Address, City, State, Zipcode);
            // get parameters from the request
           request.setAttribute("Customer", customer);
           url = "/Sucess.jsp";}
              
          
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