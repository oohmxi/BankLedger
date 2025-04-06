/*
 * Project Name: BankLedger
 * Author: Omar Hernandez
 * Date: December 8th, 2023
 * File: Account.java
 * Description: Base class for managing standard bank account data and transactions.
 */

package com.omar.bankledger;

import java.util.ArrayList;

/**
 * Represents a general-purpose bank account with basic transaction functionality.
 */
public class Account {
    private String accountOwnerName;
    private int accountNumber;
    private double accountBalance;
    private ArrayList<String> transactionHistory;

    /**
     * Constructs a new Account.
     * @param ownerName the name of the account holder
     * @param accountNumber the unique account number
     * @param balance the initial account balance
     */
    public Account(String ownerName, int accountNumber, double balance) {
        this.accountOwnerName = ownerName;
        this.accountNumber = accountNumber;
        this.accountBalance = balance;
        this.transactionHistory = new ArrayList<>();
        this.transactionHistory.add("Account created with balance: $" + balance);
    }

    public String getAccountOwnerName() {
        return accountOwnerName;
    }

    public void setAccountOwnerName(String accountOwnerName) {
        this.accountOwnerName = accountOwnerName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
        transactionHistory.add("Account balance updated to: $" + accountBalance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            accountBalance += amount;
            transactionHistory.add("Deposited: $" + amount);
        } else {
            transactionHistory.add("Failed deposit attempt: Invalid amount " + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= accountBalance) {
            accountBalance -= amount;
            transactionHistory.add("Withdrew: $" + amount);
        } else {
            transactionHistory.add("Failed withdrawal attempt: Invalid amount " + amount);
        }
    }

    public ArrayList<String> getTransactionHistory() {
        return transactionHistory;
    }

    public String getAccountSummary() {
        return "Account Owner: " + accountOwnerName +
               "\nAccount Number: " + accountNumber +
               "\nAccount Balance: $" + String.format("%.2f", accountBalance);
    }

    @Override
    public String toString() {
        return getAccountSummary();
    }
}
