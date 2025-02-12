package problem.bank;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static problem.bank.BankAccount.TransactionStatus.COMPLETED;
import static problem.bank.BankAccount.TransactionStatus.INVALID;
import static problem.bank.BankAccount.TransactionStatus.REJECTED;
import static problem.bank.BankAccount.TransactionType.DEPOSIT;
import static problem.bank.BankAccount.TransactionType.WITHDRAW;

class BankAccount {
    private final String accountNumber;
    private double balance;
    private final List<Transaction> transactionHistory;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add(new Transaction(COMPLETED, DEPOSIT, amount, ""));
        } else {
            transactionHistory.add(new Transaction(INVALID, DEPOSIT, amount, "Amount must be greater than 0"));
        }
    }

    public void withdraw(double amount) {
        if (amount >= balance) {
            transactionHistory.add(new Transaction(REJECTED, WITHDRAW, amount, "Insufficient funds"));
        } else {
            balance -= amount;
            transactionHistory.add(new Transaction(COMPLETED, WITHDRAW, amount, ""));
        }
    }

    public double getBalance() {
        return balance;
    }

    /**
     * Prints account information and transactions list
     */
    public void printTransactionHistory() {
        System.out.println("Transaction history for account: " + accountNumber);
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
    
    enum TransactionStatus {
        COMPLETED,
        REJECTED,
        INVALID
    }
    
    enum TransactionType {
        DEPOSIT,
        WITHDRAW
    }
    
    static class Transaction {
       private final TransactionStatus status;
       private final TransactionType type;
       private final double amount;
       private final String description;
       private final Instant transactionTime;
       
       public Transaction (TransactionStatus status, TransactionType type, double amount, String description) {
           this.status = status;
           this.type = type;
           this.amount = amount;
           this.description = description;
           this.transactionTime = Instant.now();
       }
       
       public String toString() {
           return "Transaction: " + status + " " + type + " " + amount + " " + description + " " + transactionTime;
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
        
        account.printTransactionHistory();
        System.out.println("Final Balance: " + account.getBalance());
    }
}
