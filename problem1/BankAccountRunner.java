package problem1;

import java.util.ArrayList;
import java.util.List;

class BankAccount {
    private String accountNumber;
    private String accountType;
    private String accountHolder;
    private double balance;
    private List<String> transationHistory;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transationHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transationHistory.add("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds");
        } else {
            balance -= amount;
            transationHistory.add("Withdrawn: " + amount);
        }
    }

    public double getBalance() {
        return balance;
    }

    /**
     * Prints account information and transactions list
     */
    public void printTransactionHistory() {
        for (String transaction : transationHistory) {
            System.out.println(transaction);
        }
    }
}

public class BankAccountRunner {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456789");

        account.deposit(1000);
        account.withdraw(500);
        account.withdraw(600);
        account.deposit(-200);

        System.out.println("Final Balance: " + account.getBalance());
        account.printTransactionHistory();
    }
}
