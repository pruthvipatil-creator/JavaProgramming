package bankingsystem;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Bank {

    private final Map<Integer, Account> accounts;
    private final String bankName;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.accounts = new HashMap<>();
    }

    public Account openSavingsAccount(
            String holderName,
            double initialDeposit,
            double interestRate) {

        SavingsAccount acc =
                new SavingsAccount(holderName, initialDeposit, interestRate);

        accounts.put(acc.getAccountNumber(), acc);

        return acc;
    }

    public Account openCurrentAccount(
            String holderName,
            double initialDeposit,
            double overdraftLimit) {

        CurrentAccount acc =
                new CurrentAccount(holderName, initialDeposit, overdraftLimit);

        accounts.put(acc.getAccountNumber(), acc);

        return acc;
    }

    public Account getAccount(int accNumber)
            throws AccountNotFoundException {

        Account acc = accounts.get(accNumber);

        if (acc == null) {
            throw new AccountNotFoundException(
                    "No account found with number: " + accNumber
            );
        }

        return acc;
    }

    public void transfer(
            int fromAcc,
            int toAcc,
            double amount)
            throws AccountNotFoundException, InsufficientBalanceException {

        Account from = getAccount(fromAcc);
        Account to = getAccount(toAcc);

        from.withdraw(amount);
        to.deposit(amount);
    }

    public void closeAccount(int accNumber)
            throws AccountNotFoundException {

        if (!accounts.containsKey(accNumber)) {

            throw new AccountNotFoundException(
                    "No account found with number: " + accNumber
            );
        }

        accounts.remove(accNumber);
    }

    public Collection<Account> getAllAccounts() {
        return accounts.values();
    }

    public String getBankName() {
        return bankName;
    }
}