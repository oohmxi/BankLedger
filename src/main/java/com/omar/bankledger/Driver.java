/*
 * Project Name: BankLedger
 * Author: Omar Hernandez
 * Date: December 8th, 2024
 * File: Driver.java
 * Description: Main program to demonstrate the use of Account and Savings classes
 *              with transactions, interest, and summary output.
 */

 package com.omar.bankledger;

 /**
  * Demonstrates the use of Account and Savings classes in a banking simulation.
  */
 public class Driver {
 
     /**
      * Main method to execute the BankLedger program.
      * @param args command-line arguments (not used)
      */
     public static void main(String[] args) {
         Account checkingAccount = new Account("Alex Developer", 1001, 6922.83);
         Savings savingsAccount = new Savings("Jordan Engineer", 2002, 1328.00, 0.0115);
 
         checkingAccount.deposit(461.00);
         savingsAccount.deposit(881.00);
 
         checkingAccount.withdraw(125.00);
         savingsAccount.withdraw(341.00);
 
         savingsAccount.deposit(1200.00);
         savingsAccount.addInterest();
 
         System.out.println("=== Final Account Summary ===\n");
         System.out.println(checkingAccount);
         System.out.println("\nTransaction History:");
         checkingAccount.getTransactionHistory().forEach(System.out::println);
 
         System.out.println("\n-----------------------------\n");
 
         System.out.println(savingsAccount);
         System.out.println("\nTransaction History:");
         savingsAccount.getTransactionHistory().forEach(System.out::println);
     }
 }
 