package bankingsystem;

import java.util.Scanner;

public class BankingApp {

    private static final Bank bank = new Bank("OOP National Bank");
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("=== Welcome to " + bank.getBankName() + " ===");

        boolean running = true;

        while (running) {

            printMenu();

            int choice = readInt("Enter choice: ");

            switch (choice) {

                case 1 -> openAccount();

                case 2 -> depositMoney();

                case 3 -> withdrawMoney();

                case 4 -> checkBalance();

                case 5 -> transferMoney();

                case 6 -> printStatement();

                case 7 -> listAllAccounts();

                case 8 -> applyInterest();

                case 9 -> closeAccount();

                case 0 -> {
                    running = false;
                    System.out.println("Thank you for banking with us!");
                }

                default -> System.out.println("Invalid choice, try again.");
            }
        }

        scanner.close();
    }

    private static void printMenu() {

        System.out.println("\n---------- MENU ----------");
        System.out.println("1. Open New Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Check Balance");
        System.out.println("5. Transfer Money");
        System.out.println("6. Print Mini Statement");
        System.out.println("7. List All Accounts");
        System.out.println("8. Apply Interest (Savings)");
        System.out.println("9. Close Account");
        System.out.println("0. Exit");
        System.out.println("---------------------------");
    }

    private static void openAccount() {

        System.out.print("Enter holder name: ");
        String name = scanner.nextLine();

        double deposit = readDoublePrompt("Enter initial deposit: ");

        System.out.println("Select account type:");
        System.out.println("1. Savings");
        System.out.println("2. Current");

        int type = readInt("Enter choice: ");

        Account acc;

        if (type == 1) {

            double rate = readDoublePrompt("Enter interest rate (%): ");

            acc = bank.openSavingsAccount(name, deposit, rate);

        } else if (type == 2) {

            double overdraft = readDoublePrompt("Enter overdraft limit: ");

            acc = bank.openCurrentAccount(name, deposit, overdraft);

        } else {

            System.out.println("Invalid account type.");
            return;
        }

        System.out.println("Account created successfully!");
        System.out.println(acc);
    }

    private static void depositMoney() {

        int accNum = readInt("Enter account number: ");

        try {

            Account acc = bank.getAccount(accNum);

            double amount = readDoublePrompt("Enter amount to deposit: ");

            acc.deposit(amount);

            System.out.printf(
                    "Deposited successfully. New balance: %.2f%n",
                    acc.getBalance()
            );

        } catch (AccountNotFoundException | IllegalArgumentException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void withdrawMoney() {

        int accNum = readInt("Enter account number: ");

        try {

            Account acc = bank.getAccount(accNum);

            double amount = readDoublePrompt("Enter amount to withdraw: ");

            acc.withdraw(amount);

            System.out.printf(
                    "Withdrawal successful. New balance: %.2f%n",
                    acc.getBalance()
            );

        } catch (
                AccountNotFoundException
                | InsufficientBalanceException
                | IllegalArgumentException e
        ) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void checkBalance() {

        int accNum = readInt("Enter account number: ");

        try {

            Account acc = bank.getAccount(accNum);

            System.out.println(acc);

        } catch (AccountNotFoundException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void transferMoney() {

        int fromAcc = readInt("Enter source account number: ");

        int toAcc = readInt("Enter destination account number: ");

        double amount = readDoublePrompt("Enter amount to transfer: ");

        try {

            bank.transfer(fromAcc, toAcc, amount);

            System.out.println("Transfer successful!");

        } catch (
                AccountNotFoundException
                | InsufficientBalanceException e
        ) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void printStatement() {

        int accNum = readInt("Enter account number: ");

        try {

            Account acc = bank.getAccount(accNum);

            System.out.println(
                    "--- Mini Statement for Acc#" + accNum + " ---"
            );

            if (acc.getTransactions().isEmpty()) {

                System.out.println("No transactions yet.");

            } else {

                acc.getTransactions().forEach(System.out::println);
            }

        } catch (AccountNotFoundException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void listAllAccounts() {

        var all = bank.getAllAccounts();

        if (all.isEmpty()) {

            System.out.println("No accounts in the bank yet.");
            return;
        }

        all.forEach(System.out::println);
    }

    private static void applyInterest() {

        int accNum = readInt("Enter account number: ");

        try {

            Account acc = bank.getAccount(accNum);

            if (acc instanceof SavingsAccount savings) {

                savings.applyInterest();

            } else {

                System.out.println(
                        "Interest can only be applied to Savings accounts."
                );
            }

        } catch (AccountNotFoundException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void closeAccount() {

        int accNum = readInt("Enter account number to close: ");

        try {

            bank.closeAccount(accNum);

            System.out.println("Account closed successfully.");

        } catch (AccountNotFoundException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    private static int readInt(String prompt) {

        System.out.print(prompt);

        while (!scanner.hasNextInt()) {

            System.out.print("Please enter a valid number: ");

            scanner.next();
        }

        int value = scanner.nextInt();

        scanner.nextLine();

        return value;
    }

    private static double readDouble() {

        while (!scanner.hasNextDouble()) {

            System.out.print("Please enter a valid number: ");

            scanner.next();
        }

        double value = scanner.nextDouble();

        scanner.nextLine();

        return value;
    }

    private static double readDoublePrompt(String prompt) {

        System.out.print(prompt);

        return readDouble();
    }
}