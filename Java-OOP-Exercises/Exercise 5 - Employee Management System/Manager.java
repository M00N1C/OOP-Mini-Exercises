public class Manager extends FullTimeEmployee {
    private int teamSize;

    public Manager(String name, int employeeID, double baseSalary, double bonus, int teamSize) {
        super(name, employeeID, baseSalary, bonus);
        this.teamSize = teamSize;
    }

    public String getRole(){
        return "Manager";
    }

    public double calculateSalary() {
        return baseSalary + bonus / 12 + teamSize * 100;
    }
}
