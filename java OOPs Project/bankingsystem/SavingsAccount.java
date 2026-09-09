package bankingsystem;

public class SavingsAccount extends Account {

    private static final double MIN_BALANCE = 500.0;
    private final double interestRate;

    public SavingsAccount(
            String holderName,
            double initialDeposit,
            double interestRate) {

        super(holderName, initialDeposit);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount)
            throws InsufficientBalanceException {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Withdrawal amount must be positive"
            );
        }

        if (balance - amount < MIN_BALANCE) {

            throw new InsufficientBalanceException(
                    "Insufficient balance. Savings account must maintain a minimum balance of "
                            + MIN_BALANCE
            );
        }

        balance -= amount;

        recordWithdrawal(amount);
    }

    public void applyInterest() {

        double interest = balance * interestRate / 100;

        deposit(interest);

        System.out.printf(
                "Interest of %.2f applied at %.2f%%%n",
                interest,
                interestRate
        );
    }

    @Override
    public String getAccountType() {
        return "Savings";
    }
}