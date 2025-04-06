/*
 * Project Name: BankLedger
 * Author: Omar Hernandez
 * Date: December 8th, 2024
 * File: Savings.java
 * Description: Inherits from Account and adds interest calculation functionality.
 */

 package com.omar.bankledger;

 public class Savings extends Account {
     private double interestRate;
     private double totalInterestEarned;
 
     public Savings(String accountOwnerName, int accountNumber, double accountBalance, double interestRate) {
         super(accountOwnerName, accountNumber, accountBalance);
         this.interestRate = interestRate;
         this.totalInterestEarned = 0;
     }
 
     public double getInterestRate() {
         return interestRate;
     }
 
     public void setInterestRate(double interestRate) {
         this.interestRate = interestRate;
     }
 
     public double computeInterest() {
         return getAccountBalance() * interestRate;
     }
 
     public void addInterest() {
         double interest = computeInterest();
         deposit(interest);
         totalInterestEarned += interest;
         getTransactionHistory().add("Interest credited: $" + String.format("%.2f", interest));
     }
 
     public double getTotalInterestEarned() {
         return totalInterestEarned;
     }
 
     @Override
     public String toString() {
         return super.toString() +
                "\nInterest Rate: " + (interestRate * 100) + "%" +
                "\nTotal Interest Earned: $" + String.format("%.2f", totalInterestEarned);
     }
 }
 