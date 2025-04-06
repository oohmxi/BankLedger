### 🏦 BankLedger

A clean, object-oriented Java banking simulator that mirrors real-world financial behavior through **depositing, withdrawing, and earning interest**. Designed for clarity, modularity, and professional demonstration.

---

## 📌 Overview

- **Author:** Omar Hernandez
- **Date:** December 8th, 2024
- **Language:** Java 17 (Maven-based project)

BankLedger simulates **basic checking and savings accounts**, showcasing practical software engineering techniques such as:

- Encapsulation of financial data
- Inheritance through a `Savings` account subclass
- Transaction logging and balance tracking

---

## 💸 Financial Analogy

Imagine two real clients at a bank:

- **Alex Developer** has a standard checking account.
- **Jordan Engineer** uses a savings account that earns interest.

This program tracks their financial activities:

- Deposits and withdrawals
- Account summaries
- Interest earned over time (only for savings)

Think of it as **a digital ledger**, but built in Java.

---

## 💡 Core Features

- ✅ **Modular OOP Design:** Separate classes for account types
- ✅ **Live Ledger History:** Tracks every transaction
- ✅ **Interest Engine:** Automatically computes & applies savings interest
- ✅ **Readable CLI Output:** Clear summary and history for each user

---

## 📊 Architecture Diagram (UML)

> 📱 **Mobile Friendly:** Embedded as image instead of Mermaid for full compatibility
> 📂 `./bankledger.png`

![BankLedger UML Diagram](./bankledger.png)

---

## 🧪 Compile & Run

### ▶️ Run via Maven

```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.omar.bankledger.Driver"
```
