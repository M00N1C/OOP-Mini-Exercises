import java.util.Scanner;

public class RunBank {

    Scanner input = new Scanner(System.in);
    private CostumersList costumersList = new CostumersList();

    public static void main(String[] args) {
        RunBank runBank = new RunBank();
        runBank.runMenu();
    }

    public void runMenu(){
        while (true) {
            printHeader("Main Menu");
            System.out.println("1. Add Account");
            System.out.println("2. View Accounts");
            System.out.println("3. Exit Program");
            System.out.print("Enter choice: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    addAccount();
                    break;
                case 2:
                    viewAccounts();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }

        }
    }

    public void addAccount(){
        printHeader("Adding an Account");
        System.out.print("Enter account number: ");
        int accountNumber = input.nextInt();
        System.out.print("Enter Owner name: ");
        String ownerName = input.next();
        double balance;
        while(true) {
            System.out.print("Enter intitialBalance: ");
            double intitialBalance = input.nextDouble();

            if(intitialBalance < 0){
                System.out.println("initial balance cannot be negative!");
            }
            else {
                balance = intitialBalance;
                break;
            }
        }
        String accountType;
        while (true) {
            System.out.print("Enter Account Type: (Savings / Checking) ");

            String accType = input.next();
            if (accType.equalsIgnoreCase("Savings")) {
                accountType = "Savings";
                break;
            } else if (accType.equalsIgnoreCase("Checking")) {
                accountType = "Checking";
                break;
            } else {
                System.out.println("Invalid Account Type");
            }
        }
        BankAccount bankAccount = new BankAccount(accountNumber, ownerName, balance, accountType);
        costumersList.addAccount(bankAccount);
        System.out.println("Account number " + accountNumber + " added Successfully!");
    }

    public void viewAccounts() {
        if(costumersList.getCostumersList().isEmpty()){
            System.out.println("No accounts found");
            return;
        }
        while (true) {
            printHeader("View Accounts");
            System.out.println("1. View Accounts by Creation date / Use account");
            System.out.println("2. View Accounts by balance");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter choice: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    viewAndUseAccount();
                case 2:
                    costumersList.printByBalance();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public void viewAndUseAccount() {
        while (true) {
            printHeader("View And Edit Accounts");
            costumersList.printCostumersList();
            System.out.println("Enter account number you want to access: ");
            int accountNumber = input.nextInt();
            boolean accountExists = false;
            for(BankAccount b : costumersList.getCostumersList()){
                if(b.getAccountNumber() == accountNumber){
                    useAccount(b);
                    accountExists = true;
                    break;
                }
            }
            if(!accountExists){
                System.out.println("Account number " + accountNumber + " doesn't exists");
            }
        }
    }

    public void useAccount(BankAccount bankAccount) {
        while (true) {
            printHeader("Using Account " + bankAccount.getAccountNumber());
            System.out.println("1.Deposit : ");
            System.out.println("2.Withdraw : ");
            System.out.println("3.Transfer : ");
            System.out.println("4.Back to viewAccounts : ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter number to deposit : ");
                    int deposit = input.nextInt();
                    bankAccount.deposit(deposit);
                    break;
                case 2:
                    System.out.print("Enter number to withdraw : ");
                    int withdraw = input.nextInt();
                    bankAccount.withdraw(withdraw);
                    break;
                case 3:
                    System.out.print("Enter number to transfer : ");
                    int transfer = input.nextInt();
                    System.out.println();
                    System.out.print("Enter Account number to transfer to : ");
                    int accountNumber = input.nextInt();
                    bankAccount.transfer(transfer, accountNumber, costumersList);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public void printHeader(String header){
        System.out.println("------------------------------");
        System.out.print("-");
        for(int i = 0; i < 29 - header.length(); i++){
            if(i == (28 - header.length()) / 2){
                System.out.print(header);
            }
            else System.out.print(" ");
        }
        System.out.println("-");
        System.out.println("------------------------------");
    }

}
