package toba;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import business.Account;
import static business.Account_.user;
import business.User;
import business.transaction;
import data.AccountDB;
import data.UserDB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet( urlPatterns = {"/TransactionServlet"})
public class TransactionServlet extends HttpServlet {
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String amount = request.getParameter("amount");
        String message1="";
        String url="";
        
        session.setAttribute("user", user);
        Account checking = AccountDB.selectAccount(user, "checking");
        Account savings = AccountDB.selectAccount(user, "savings");
        //Account checking = (Account)session.getAttribute("checking");
        // Account savings = (Account)session.getAttribute("savings");
        
        Double checkingBal = checking.getStartingBal();
        Double savingsBal = savings.getStartingBal();
        if ( Double.parseDouble(amount) >= savingsBal){ 
           message1="Insufficient Amount";
              url = "/transfer.jsp";
              request.setAttribute("message1", message1);
        } 
        else {
        checking.credit(Double.parseDouble(amount));
        transaction t1 = new transaction(
                checkingBal, Double.parseDouble(amount), checking.getStartingBal(), "Credit");
        checking.addTransactions(t1);
        
        savings.debit(Double.parseDouble(amount));
        transaction t2 = new transaction(
                savingsBal, Double.parseDouble(amount), savings.getStartingBal(), "Debit");
        savings.addTransactions(t2);
        
        
        AccountDB.update(savings);
        AccountDB.update(checking);
       // User user = (User)session.getAttribute("user");
        session.setAttribute("checking", checking);
        session.setAttribute("savings", savings);
        request.setAttribute("message1", message1);
         url=  "/Account_activity.jsp" ;
       
        }
    getServletContext()
            .getRequestDispatcher(url)
                  //  )
            .forward(request, response);}

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
 
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
