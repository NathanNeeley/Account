// Class:      CS 5000
// Term:       Fall 2019
// Name:       Nathan Neeley
// Instructor: Dr. Haddad
// Assignment: 8
// IDE Name:   Jgrasp
// program that creates three objects and prints out meaningful information from them

import java.util.Scanner; //import scanner class
import java.text.NumberFormat; //import Number Format class
import java.text.DecimalFormat; //import Decimal Format class

public class TestAccount
{
   public static void main(String args[]) //program main method 
   {
      Scanner input = new Scanner(System.in);
      char another = 'y'; //intialize another variable for user to rerun program or not
      DecimalFormat PercentageFormat1 = new DecimalFormat("0.00%"); //create PercentageFormat with two decimal places
      DecimalFormat PercentageFormat2 = new DecimalFormat("0.000%"); //create PercentageFormat with two decimal places
      NumberFormat MoneyFormat = NumberFormat.getCurrencyInstance(); //create MoneyFormat
      boolean replay = true;
      
      //myObject Object
      Account myObject = new Account(12345, 10000); //create myObject from Account constructor with two parameters
      myObject.setAnnualInterestRate(2.5); //update AnnualInterestRate
      myObject.withdraw(3500); //withdraw 3500 from Account 
      myObject.deposit(500);  //deposite 500 into Account
      
      System.out.println("Account Balance: \t" + MoneyFormat.format(myObject.getBalance())); //print out myObject Account Balance
      System.out.println("Monthly Interest: " + MoneyFormat.format(myObject.getMonthlyInterest()/100)); //print out myObject monthly interest
      System.out.println("Date Opened: \t\t" + myObject.getDateCreated()); //print out myObject date it was created
      System.out.println(myObject); //print out myObject toString()
   
      while (Character.toLowerCase(another) == 'y') {
         
         do {
            try {
            //myAccount Object
               System.out.print("\nPlease enter myAccount ID: "); //prompt user to enter myAccount ID
               int myAccountID = input.nextInt(); //read myAccountID from user
               assert myAccountID > 0 : "Invalid ID. Program is terminated.";
               System.out.print("Please enter myAccount balance: "); //prompt user to enter myAccount balance
               double myAccountBalance = input.nextDouble(); //read myAccountBalance from user
               System.out.print("Please enter myAccount annual interest rate: "); //prompt user to enter annual interest rate
               double myAccountAnnualInterestRate = input.nextDouble(); //read myAccountAnnualInterestRate 
               
               Account myAccount = new Account(myAccountID, myAccountBalance); //create myAccount object with parameters from user input
               myAccount.setBalance(myAccountBalance); //update myAccountBalance
               myAccount.setAnnualInterestRate(myAccountAnnualInterestRate); //update myAccountAnnualInterestRate
               myAccount.setID(myAccountID); //update myAccountID
            
               System.out.println("Account ID: \t\t\t\t" + myAccount.getID()); //print out myAccount ID
               System.out.println("Account Balance: \t\t\t" + MoneyFormat.format(myAccount.getBalance())); //print out myAccount balance
               System.out.println("Annual Interest Rate: \t" + PercentageFormat1.format(myAccount.getAnnualInterestRate()/100)); //print out myAccount annual interest rate
               System.out.println("Monthly Interest Rate: \t" + PercentageFormat2.format(myAccount.getMonthlyInterestRate()/100)); //print out myAccount monthly interest rate
               System.out.println("Monthly Interest: \t\t" + MoneyFormat.format(myAccount.getMonthlyInterest()/100)); //print out myAccount monthly interest
               System.out.println("Date Opened: \t\t\t\t" + myAccount.getDateCreated()); //print out myAccount date that it was created
               replay = false;
            }
            
            catch (IllegalArgumentException ex) {
               System.out.println(ex.getMessage());
               input.nextLine();
            }
         } while (replay == true);
         replay = true;
         
         do {
            try {
            //yourAccount Object
               System.out.print("\nPlease enter yourAccount ID: "); //prompt user for yourAccount ID
               int yourAccountID = input.nextInt(); //read yourAccountID from user
               assert yourAccountID > 0 : "You entered invalid ID. Program is terminated."; //validate yourAccountID
               System.out.print("Please enter yourAccount balance: "); //prompt user for yourAccount balance
               double yourAccountBalance = input.nextDouble(); //read yourAccountBalance from user
               System.out.print("Please enter yourAccount annual interest rate: "); //prompt user for yourAccount annual interest rate
               double yourAccountAnnualInterestRate = input.nextDouble(); //read yourAccountAnnualInterestRate from user
            
               Account yourAccount = new Account(yourAccountID, yourAccountBalance); //create yourAccount object with parameters from user input
               yourAccount.setAnnualInterestRate(yourAccountAnnualInterestRate); //update yourAccountAnnualInterestRate
               yourAccount.setID(yourAccountID); //update yourAccountID
            
               System.out.println("Account ID: \t\t\t\t" + yourAccount.getID()); //print out yourAccount ID
               System.out.println("Account Balance: \t\t\t" + MoneyFormat.format(yourAccount.getBalance())); //print out yourAccount balance
               System.out.println("Annual Interest Rate: \t" + PercentageFormat1.format(yourAccount.getAnnualInterestRate()/100)); //print out yourAccount annual interest rate
               System.out.println("Monthly Interest Rate: \t" + PercentageFormat2.format(yourAccount.getMonthlyInterestRate()/100)); //print out yourAccount monthly interest rate
               System.out.println("Monthly Interest: \t\t" + MoneyFormat.format(yourAccount.getMonthlyInterest()/100)); //print out yourAccount monthly interest
               System.out.println("Date Opened: \t\t\t\t" + yourAccount.getDateCreated()); //print out yourAccount date that it was created
               replay = false;
            }
            
            catch (IllegalArgumentException ex2) {
               System.out.println(ex2.getMessage());
               input.nextLine();
            }
         } while (replay == true);
         
         System.out.print("Re-run program (y/n)? "); //prompts user to rerun program with different inputs
         another = input.next().charAt(0); //read char from user to rerun program or not
      }
   }
}