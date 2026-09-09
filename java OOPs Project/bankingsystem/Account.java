package bankingsystem;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {

    private static int accountCounter = 1000;

    private final int accountNumber;
    private final String holderName;

    // protected: visible to subclasses only (Encapsulation)
    protected double balance;

    private final List<Transaction> transactions;

    public Account(String holderName, double initialDeposit) {

        this.accountNumber = ++accountCounter;
        this.holderName = holderName;
        this.balance = initialDeposit;
        this.transactions = new ArrayList<>();

        if (initialDeposit > 0) {
            transactions.add(
                new Transaction("DEPOSIT", initialDeposit, balance)
            );
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void deposit(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Deposit amount must be positive"
            );
        }

        balance += amount;

        transactions.add(
            new Transaction("DEPOSIT", amount, balance)
        );
    }

    // Polymorphism: each subclass implements its own withdrawal rules
    public abstract void withdraw(double amount)
            throws InsufficientBalanceException;

    public abstract String getAccountType();

    protected void recordWithdrawal(double amount) {

        transactions.add(
            new Transaction("WITHDRAW", amount, balance)
        );
    }

    @Override
    public String toString() {

        return String.format(
            "Acc#%d | %-10s | %-15s | Balance: %.2f",
            accountNumber,
            getAccountType(),
            holderName,
            balance
        );
    }
}