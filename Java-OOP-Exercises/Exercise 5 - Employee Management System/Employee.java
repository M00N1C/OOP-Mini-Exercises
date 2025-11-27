public abstract class Employee {
    protected String name;
    protected double baseSalary;
    protected int employeeID;

    public Employee(String name, int employeeID, double baseSalary) {
        this.name = name;
        this.employeeID = employeeID;
        this.baseSalary = baseSalary;
    }

    public void displayEmployee() {
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Salary: " + calculateSalary());
        System.out.println("Role: " + getRole());
    }

    public abstract double calculateSalary();

    public abstract String getRole();
}
