/*
 * Project Name: BankLedger
 * Author: Omar Hernandez
 * Date: December 8th, 2024
 * File: Driver.java
 * Description: Main program to demonstrate the use of Account and Savings classes
 *              with transactions, interest, and summary output.
 */

 package com.omar.bankledger;

 public class Driver {
     public static void main(String[] args) {
         Account checkingAccount = new Account("Alice Customer", 10001, 6922.83);
         Savings savingsAccount = new Savings("Bob Saver", 10002, 1328.00, 0.0115);
 
         checkingAccount.deposit(461);
         savingsAccount.deposit(881);
 
         checkingAccount.withdraw(125);
         savingsAccount.withdraw(341);
 
         savingsAccount.deposit(1200);
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
 