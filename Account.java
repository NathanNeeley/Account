// program that creates constructors and getter and setter methods to use in TestAccount

import java.util.Scanner; //import scanner class
import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.util.Date; //import Date class

public class Account {
   private int id; //declare id variable
   private double balance; //declare balance variable
   private double annualInterestRate; //declare annualInterestRate variable
   private Date dateCreated = new Date(); //initialize Date object
   private NumberFormat MoneyFormat = NumberFormat.getCurrencyInstance(); //initialize NumberFormat object for currency
   private DecimalFormat PercentageFormat = new DecimalFormat("0.00%"); //initialize DecimalFormat object for 2 decimal places
   
   Account() {
      id = 0; //initialize id with default value
      balance = 0.0; //initialize balance with default value
      annualInterestRate = 0.0; //initialize annualInterestRate with default value
   }
   
   Account(int newID, double newBalance) throws IllegalArgumentException {
      id = newID; //update id with input value in constructor
      if (newBalance <= 0)
         throw new IllegalArgumentException("balance can not be 0 or less");
      else
         balance = newBalance; //update balance with input value in constructor
   }
   
   public int getID() {
      return id; //return id variable
   }
   
   public void setID(int newID) {
      id = newID; //update id with parameter value
   }
   
   public double getBalance() {
      return balance; //return balance variable
   }
   
   public void setBalance(double newBalance) throws IllegalArgumentException {
      if (newBalance <= 0)
         throw new IllegalArgumentException("balance can not be 0 or less");
      else
         balance = newBalance; //update balance with parameter value
   }
   
   public double getAnnualInterestRate() {
      return annualInterestRate; //return annualInterestRate variable
   }
   
   public void setAnnualInterestRate(double newAnnualInterestRate) throws IllegalArgumentException {
      if (newAnnualInterestRate <= 0)
         throw new IllegalArgumentException("annual interest rate can not be 0 or less");
      else 
         annualInterestRate = newAnnualInterestRate; //update annualInterestRate with parameter value
   }
   
   public Date getDateCreated() {
      return dateCreated; //return dateCreated object
   }
   
   public double getMonthlyInterestRate() {
      return annualInterestRate/12; //return monthly interest rate by dividing annualInterestRate by 12
   }
   
   public double getMonthlyInterest() {
      return balance * getMonthlyInterestRate(); //return monthly interest
   }
   
   public void withdraw(double withdrawal) throws IllegalArgumentException {
      if (withdrawal <= 0)
         throw new IllegalArgumentException("withdrawal can not be 0 or less");
      else if (withdrawal > balance)
         throw new IllegalArgumentException("withdrawal can not be larger than balance");
      else
         balance = balance - withdrawal; //update balance after a withdrawal
   }
   
   public void deposit(double deposited) throws IllegalArgumentException {
      if (deposited <= 0)
         throw new IllegalArgumentException("deposit can not be 0 or less");
      else
         balance = balance + deposited; //update balance after a deposit
   }
   
   public String toString() {
      return ("\nAccount ID: \t\t" + id + "\nAccount Balance: \t" + MoneyFormat.format(balance) + "\nInterest Rate: \t" + PercentageFormat.format(annualInterestRate/100) + "\nDate Opened: \t\t" + dateCreated); //return meaningful description of instance variables
   }
} 
   
