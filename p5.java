class Employee {
    int id;
    String name;
    double monthlySalary;
    static String companyName = "Innovatech technology solutions";

    public Employee(int id, String name, double monthlySalary) {
        this.id = id;
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public double calculateAnnualSalary() {
        return monthlySalary * 12;
    }

    public void displayEmployeeDetails() {
        System.out.println("Company: " + companyName);
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("Monthly Salary: " + monthlySalary);
        System.out.println("Annual Salary: " + calculateAnnualSalary());
    }
}

public class p5 {
    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "srivan",8000);
        Employee emp2 = new Employee(2, "sathwik",8100);

        emp1.displayEmployeeDetails();
        emp2.displayEmployeeDetails();
    }
}
