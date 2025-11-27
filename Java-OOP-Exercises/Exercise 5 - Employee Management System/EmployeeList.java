import java.util.ArrayList;
import java.util.List;

public class EmployeeList {
    private List<Employee> Elist = new ArrayList<>();

    public void addEmployee(Employee e) {
        Elist.add(e);
    }

    public List<Employee> getEmployees() {
        return Elist;
    }

    public void displayEmployees() {
        int counter = 1;
        for (Employee e : Elist) {
            System.out.print(counter + ". " );
            e.displayEmployee();
            counter++;
            System.out.println();
        }
    }
}
