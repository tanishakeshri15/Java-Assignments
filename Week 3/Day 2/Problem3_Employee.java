class Employee {
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    // Constructor for permanent employee
    Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    // Constructor for intern
    Employee(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    void printProfile() {
        System.out.println(
            empId + " - " + empName +
            " - Salary: " + salary +
            " - Intern: " + isIntern
        );
    }
}

public class Problem3_Employee {
    public static void main(String[] args) {

        Employee employee1 =
            new Employee("E-101", "Divya", 65000);

        Employee employee2 =
            new Employee("E-102", "Arjun");

        employee1.printProfile();
        employee2.printProfile();
    }
}