/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author hassane
 */


import data.AccountDB;
/**
 *
 * @author hassane
 */import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class User implements Serializable {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
private long UserID;
private String userName;
public String passWord;
    private String firstName;
    private String lastName;
    public String email;
    private String Phone;
     private String Address;
    private String City;
    private String State;
     private String Zipcode;
  
    public User() {
        firstName = "";
        lastName = "";
        email = "";
        Phone="";
        Address="";
        City="";
        State="";
        Zipcode="";
        userName="";
        passWord="";
    }

    public User(String userName,String passWord,String firstName, String lastName, String email,String Phone,String Address, String City, String State,String Zipcode) {
       this.userName=userName;
       this.passWord=passWord;
         this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.Phone= Phone;
         this.Address = Address;
        this.City = City;
        this.State = State;
        this.Zipcode= Zipcode;
    }

    public User(String userName,String passWord, String firstName, String lastName, String email,String Address, String City, String State, String Zipcode ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
 public long getUserID(){
     return UserID;}   
 public void setUserID(long UserID){
    
     this.UserID=UserID;}
 public String getUserName() {
        return userName;
    }
  public void setUserName(String userName) {
        this.userName = userName;
    }
  public String getPassWord() {
        return passWord;
    }
   public void setPassWord(String password) {
        this.passWord = password;
    }
    public String getFirstName() {
        return firstName;
    }
    

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
     public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }
     public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
     public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }
     public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }
     public String getZipcode() {
        return Zipcode;
    }

    public void setZipcode(String Zipcode) {
        this.Zipcode = Zipcode;
    }
    
    public double getCheckingBalance(){
        Account checking = AccountDB.selectAccount(this, "checking");
        if (checking != null) 
            return checking.getStartingBal();
        return 0.00;
    }
    public double getSavingsBalance(){
        Account savings = AccountDB.selectAccount(this, "savings");
        if (savings != null) 
            return savings.getStartingBal();
        return 0.00;
    }
}
