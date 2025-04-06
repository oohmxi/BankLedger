package com.omar.bankledger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the BankLedger application.
 */
public class BankLedgerTest {

    private Account testAccount;
    private Savings testSavings;

    @BeforeEach
    void setup() {
        testAccount = new Account("Test User", 12345, 1000.00);
        testSavings = new Savings("Test Saver", 54321, 500.00, 0.05);
    }

    @Test
    void testDeposit() {
        testAccount.deposit(500.00);
        assertEquals(1500.00, testAccount.getAccountBalance(), 0.001);
    }

    @Test
    void testWithdraw() {
        testAccount.withdraw(300.00);
        assertEquals(700.00, testAccount.getAccountBalance(), 0.001);
    }

    @Test
    void testWithdrawOverdraftFails() {
        testAccount.withdraw(1200.00);
        assertEquals(1000.00, testAccount.getAccountBalance(), 0.001); // unchanged
    }

    @Test
    void testAddInterest() {
        testSavings.addInterest();
        double expectedBalance = 500.00 + (500.00 * 0.05);
        assertEquals(expectedBalance, testSavings.getAccountBalance(), 0.001);
    }
}
