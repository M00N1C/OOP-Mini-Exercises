import java.util.Scanner;

public class RunEmployeeManagement {

    private EmployeeList Elist = new EmployeeList();
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        RunEmployeeManagement rm = new RunEmployeeManagement();
        rm.runMainMenu();
    }

    public void runMainMenu() {
        while (true) {
            printHeader("Main Menu");
            System.out.println("1. Add Employee");
            System.out.println("2. See Employee List");
            System.out.println("3. Exit");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    Elist.displayEmployees();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public void addEmployee() {
        while (true) {
            System.out.println("Enter Employee type:");
            System.out.println("1. Part-time Employee");
            System.out.println("2. Full-time Employee");
            System.out.println("3. Manager");
            System.out.println("4. Cancel");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    addPartTimeEmployee();
                    return;
                case 2:
                    addFullTimeEmployee();
                    return;
                case 3:
                    addManager();
                    return;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public void addPartTimeEmployee() {
        System.out.println("Enter Employee ID:");
        int employeeID = input.nextInt();
        System.out.println("Enter Employee Name:");
        String employeeName = input.next();
        double hourlyRate;
        while(true) {
            System.out.println("Enter hourly rate:");
            hourlyRate = input.nextDouble();
            if (hourlyRate > 0) {
                break;
            }
            System.out.println("hourly rate cannot be negative");
        }
        int workedHours;
        while(true) {
            System.out.println("Enter worked hours:");
            workedHours = input.nextInt();
            if (workedHours > 0) {
                break;
            }
            System.out.println("worked hours cannot be negative");
        }
        PartTimeEmployee p = new PartTimeEmployee(employeeName, employeeID, workedHours, hourlyRate);
        Elist.addEmployee(p);
        System.out.println("Part-time Employee " + employeeName + " added Successfully");
    }

    public void addFullTimeEmployee() {
        System.out.println("Enter Employee ID:");
        int employeeID = input.nextInt();
        System.out.println("Enter Employee Name:");
        String employeeName = input.next();
        double baseSalary;
        double bonus;
        while(true) {
            System.out.println("Enter base Salary:");
            baseSalary = input.nextDouble();
            if (baseSalary > 0) {
                break;
            }
            System.out.println("base salary cannot be negative");
        }
        while(true) {
            System.out.println("Enter bonus:");
            bonus = input.nextDouble();
            if (bonus > 0) {
                break;
            }
            System.out.println("bonus cannot be negative");
        }
        FullTimeEmployee f = new FullTimeEmployee(employeeName, employeeID, baseSalary, bonus);
        Elist.addEmployee(f);
        System.out.println("Full-time Employee " + employeeName + " added Successfully" );
    }

    public void addManager() {
        System.out.println("Enter Employee ID:");
        int employeeID = input.nextInt();
        System.out.println("Enter Employee Name:");
        String employeeName = input.next();
        double baseSalary;
        double bonus;
        int teamSize;
        while(true) {
            System.out.println("Enter base Salary:");
            baseSalary = input.nextDouble();
            if (baseSalary > 0) {
                break;
            }
            System.out.println("base salary cannot be negative");
        }
        while(true) {
            System.out.println("Enter bonus:");
            bonus = input.nextDouble();
            if (bonus > 0) {
                break;
            }
            System.out.println("bonus cannot be negative");
        }
        while(true) {
            System.out.println("Enter teamSize:");
            teamSize = input.nextInt();
            if (teamSize > 0) {
                break;
            }
            System.out.println("teamSize be negative");
        }
        Manager m = new Manager(employeeName, employeeID, baseSalary, bonus, teamSize);
        Elist.addEmployee(m);
        System.out.println("Manager " + employeeName + " added successfully");
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
