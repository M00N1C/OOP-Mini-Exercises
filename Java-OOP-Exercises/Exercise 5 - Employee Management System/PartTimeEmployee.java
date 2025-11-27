public class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlySalary;
    public PartTimeEmployee(String name, int employeeID, int hoursWorked, double hourlySalary) {
        this.name = name;
        this.employeeID = employeeID;
        this.hoursWorked = hoursWorked;
        this.hourlySalary = hourlySalary;
    }

    @Override
    public double calculateSalary() {
        return hourlySalary * hoursWorked;
    }

    @Override
    public String getRole() {
        return "Part-Time Employee";
    }
}
