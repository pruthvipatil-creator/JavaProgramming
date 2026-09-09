package bankingsystem;

public class CurrentAccount extends Account {

    private final double overdraftLimit;

    public CurrentAccount(
            String holderName,
            double initialDeposit,
            double overdraftLimit) {

        super(holderName, initialDeposit);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount)
            throws InsufficientBalanceException {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Withdrawal amount must be positive"
            );
        }

        if (balance - amount < -overdraftLimit) {

            throw new InsufficientBalanceException(
                    "Insufficient balance. Overdraft limit of "
                            + overdraftLimit
                            + " exceeded"
            );
        }

        balance -= amount;

        recordWithdrawal(amount);
    }

    @Override
    public String getAccountType() {
        return "Current";
    }
}