/*
 * Project Name: BankLedger
 * Author: Omar Hernandez
 * Date: December 8th, 2023
 * File: Savings.java
 * Description: Inherits from Account and adds interest calculation functionality.
 */

package com.omar.bankledger; // Fixed package declaration

/**
 * Represents a savings account that earns interest over time.
 * Inherits from the base Account class.
 */
public class Savings extends Account {
    private double interestRate;
    private double totalInterestEarned;

    /**
     * Constructs a new Savings account.
     * @param accountOwnerName the name of the account holder
     * @param accountNumber the unique account number
     * @param accountBalance the initial balance
     * @param interestRate the annual interest rate (e.g., 0.05 for 5%)
     */
    public Savings(String accountOwnerName, int accountNumber, double accountBalance, double interestRate) {
        super(accountOwnerName, accountNumber, accountBalance);
        if (interestRate < 0) {
            throw new IllegalArgumentException("Interest rate cannot be negative."); // Null check for interestRate
        }
        this.interestRate = interestRate;
        this.totalInterestEarned = 0;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        if (interestRate < 0) {
            throw new IllegalArgumentException("Interest rate cannot be negative."); // Validate input
        }
        this.interestRate = interestRate;
    }

    /**
     * Calculates the interest based on the current balance and interest rate.
     * @return the computed interest value
     */
    public double computeInterest() {
        double balance = getAccountBalance();
        if (balance <= 0) {
            return 0; // Handle edge case for non-positive balance
        }
        return balance * interestRate;
    }

    /**
     * Adds the computed interest to the account balance and logs the transaction.
     */
    public void addInterest() {
        double interest = computeInterest();
        if (interest > 0) { // Ensure interest is only added for positive balances
            deposit(interest);
            totalInterestEarned += interest;
            getTransactionHistory().add("Interest credited: $" + String.format("%.2f", interest));
        } else {
            getTransactionHistory().add("No interest credited due to non-positive balance.");
        }
    }

    public double getTotalInterestEarned() {
        return totalInterestEarned;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nInterest Rate: " + String.format("%.2f", interestRate * 100) + "%" + // Improved formatting
               "\nTotal Interest Earned: $" + String.format("%.2f", totalInterestEarned);
    }
}
