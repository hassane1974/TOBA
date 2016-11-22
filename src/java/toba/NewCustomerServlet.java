package toba;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import business.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import business.User;
import data.AccountDB;
import data.UserDB;
import java.util.Date;
import javax.persistence.ManyToOne;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/NewCustomerServlet"})
public class NewCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/index.jsp";

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "add";  // default action
        }
        if (action.equals("add")) {

            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String Phone = request.getParameter("Phone");
            String Address = request.getParameter("Address");
            String City = request.getParameter("City");
            String State = request.getParameter("State");
            String Zipcode = request.getParameter("Zipcode");
            // String userName=lastName+Zipcode;
            String s = "welcome1";
            String passWord = s;

            // get parameters from the request
            String message;
            if (firstName.equals("") || lastName.equals("") || email.equals("") || Address.equals("") || City.equals("") || State.equals("") || Zipcode.equals("")) {
                // forward to the view to get missing parameters
                message = "*********Please fill out all boxes**************";
                url = "/New_customer.jsp";
            } else {
                message = "";
                url = "/Sucess.jsp";
            }

            // store data in User object
            User user = new User();

            Account checking = new Account("checking", 0, user);
            Account savings = new Account("savings", 25.0, user);

            user.setUserName(lastName + Zipcode);
            user.setPassWord("welcome1");
            user.setEmail(email);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPhone(Phone);
            user.setAddress(Address);
            user.setCity(City);
            user.setState(State);
            user.setZipcode(Zipcode);
            //(userName,passWord,firstName, lastName, email, Phone, Address, City, State, Zipcode);

            UserDB.insert(user);
            AccountDB.insert(checking);
            AccountDB.insert(savings);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            //request.setAttribute("user", user);
            request.setAttribute("message", message);
            session.setAttribute("s", s);
            Date currentDate = new Date();
            request.setAttribute("currentDate", currentDate);

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
