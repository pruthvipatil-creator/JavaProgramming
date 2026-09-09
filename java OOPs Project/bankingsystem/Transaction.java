package bankingsystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    private final String type;
    private final double amount;
    private final double balanceAfter;
    private final LocalDateTime timestamp;

    public Transaction(String type, double amount, double balanceAfter) {

        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {

        return String.format(
                "[%s] %-8s Amount: %.2f | Balance After: %.2f",
                timestamp.format(FORMATTER),
                type,
                amount,
                balanceAfter
        );
    }
}