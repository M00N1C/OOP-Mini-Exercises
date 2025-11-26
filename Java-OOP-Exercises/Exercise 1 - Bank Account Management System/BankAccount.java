import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private final int accountNumber;
    private final String accountOwnerName;
    private double balance;
    private String accountType;
    private final LocalDateTime creationDate = LocalDateTime.now();
    private List<String> Transactions = new ArrayList<>();

    public BankAccount(int accountNumber, String accountOwnerName, double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.accountOwnerName = accountOwnerName;
        this.balance = balance;
        this.accountType = accountType;
    }
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("You can't deposit negative amount!");
            return;
        }
        this.balance += amount;
        System.out.println("Deposited " + amount + " to " + accountOwnerName);
        Transactions.add("Deposited " + amount + " to " + accountOwnerName + " in " + LocalDateTime.now());
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("You can't withdraw negative amount!");
            return;
        }
        if (amount > this.balance) {
            System.out.println("You can't withdraw more than " + this.balance + " balance!");
            return;
        }
        this.balance -= amount;
        System.out.println("Withdrawn " + amount + " to " + accountOwnerName);
        Transactions.add("Withdrawn " + amount + " to " + accountOwnerName + " in " + LocalDateTime.now());
    }

    public void transfer(double amount, int accountNumber , CostumersList CL) {
        if (amount <= 0) {
            System.out.println("You can't transfer negative amount!");
            return;
        }
        if (amount > this.balance) {
            System.out.println("You can't transfer more than " + this.balance + " balance!");
            return;
        }
        for (BankAccount b : CL.getCostumersList()){
            if (b.getAccountNumber() == accountNumber){
                b.setBalance(b.getBalance() + amount);
                this.balance -= amount;
                System.out.println("Transferred " + amount + " to " + accountOwnerName + " Successfully");
                Transactions.add("Transferred " + amount + " to " + accountOwnerName + " in " + LocalDateTime.now());
                return;
            }
        }
        System.out.println("Account number " + accountNumber + " does not exist");
    }

    public void getAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Owner: " + accountOwnerName);
        System.out.println("Balance: " + balance);
        System.out.println("Account Type: " + accountType);
        System.out.println("Creation Date: " + creationDate);
        System.out.println();
    }

    public void printTransactions() {
        System.out.println("Transactions: ");
        for (String t : Transactions){
            System.out.println(t);
        }
        System.out.println();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
