/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author hassane
 */
@Entity
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountID;
     private String accountType;
      private double startingBal;//attribute
      private User user;
      @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
      private List<transaction> transactions;
      
      public Account(){
          accountType = "";
          startingBal = 0.0;
          user = new User();
          
      }
      
      //constuctor
      public Account(String accntType, double startingBal, User acctOwner) {
          accountType = accntType;
          this.startingBal = startingBal;
          user = acctOwner;
          transactions = new ArrayList<>();
      }
      
      //method
      public double credit (double amount){
          startingBal = startingBal + amount;
          return startingBal;
      }
      public double debit (double amount){
           startingBal = startingBal - amount;
          return startingBal;
      }

    public Long getAccountID() {
        return accountID;
    }

    public void setAccountID(Long accountID) {
        this.accountID = accountID;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getStartingBal() {
        return startingBal;
    }

    public void setStartingBal(double startingBal) {
        this.startingBal = startingBal;
    }

    public User getuser() {
        return user;
    }

    public void setuser(User user) {
        this.user = user;
    }

    public List<transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<transaction> transactions) {
        this.transactions = transactions;
    }
      
    public void addTransactions(transaction t){
        transactions.add(t);
    }  
}
