package com.omar.bankledger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the BankLedger application using JUnit 5.
 */
public class BankLedgerTest {

    private Account testAccount;
    private Savings testSavings;

    /**
     * Sets up test objects before each test.
     */
    @SuppressWarnings("unused")
    @BeforeEach
    void setup() {
        testAccount = new Account("Test User", 12345, 1000.00);
        testSavings = new Savings("Test Saver", 54321, 500.00, 0.05);
    }

    @Test
    void testDeposit() {
        testAccount.deposit(500.00);
        assertEquals(1500.00, testAccount.getAccountBalance(), 0.001, "Deposit failed to update balance correctly.");
    }

    @Test
    void testWithdraw() {
        testAccount.withdraw(300.00);
        assertEquals(700.00, testAccount.getAccountBalance(), 0.001, "Withdraw failed to deduct amount correctly.");
    }

    @Test
    void testWithdrawOverdraftFails() {
        testAccount.withdraw(1200.00); // should fail
        assertEquals(1000.00, testAccount.getAccountBalance(), 0.001, "Overdraft withdrawal should not change balance.");
    }

    @Test
    void testNegativeDepositFails() {
        testAccount.deposit(-200.00); // should not be allowed
        assertEquals(1000.00, testAccount.getAccountBalance(), 0.001, "Negative deposit should not change balance.");
    }

    @Test
    void testAddInterest() {
        testSavings.addInterest();
        double expectedBalance = 500.00 + (500.00 * 0.05);
        assertEquals(expectedBalance, testSavings.getAccountBalance(), 0.001, "Interest calculation or deposit failed.");
    }
}
