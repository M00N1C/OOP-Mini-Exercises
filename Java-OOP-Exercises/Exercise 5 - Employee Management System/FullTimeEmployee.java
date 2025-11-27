public class FullTimeEmployee extends Employee {

    protected double bonus;
    public FullTimeEmployee(String name, int employeeID, double baseSalary, double bonus) {
        super(name, employeeID, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + bonus / 12;
    }

    @Override
    public String getRole() {
        return "Full-Time Employee";
    }
}
