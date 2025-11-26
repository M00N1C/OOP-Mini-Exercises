import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CostumersList {
    private List<BankAccount> CostumersList = new ArrayList<>();

    public void addAccount(BankAccount account) {
        this.CostumersList.add(account);
    }

    public List<BankAccount> getCostumersList() {
        return CostumersList;
    }

    public void printCostumersList() {
        int counter = 1;
        for (BankAccount account : this.CostumersList) {
            System.out.print(counter + ". ");
            account.getAccountInfo();
            counter++;
        }
    }

    public void printByBalance() {
        int counter = 1;
        List<BankAccount> temp = CostumersList;
        temp.sort(Comparator.comparingDouble(BankAccount::getBalance));
        for (BankAccount account : temp) {
            System.out.print(counter + ". ");
            account.getAccountInfo();
            counter++;
        }
    }
}
