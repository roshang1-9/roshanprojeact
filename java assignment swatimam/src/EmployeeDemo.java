public class EmployeeDemo {
    public static void main(String[] args) {
        Employee e1 = new Employee("Rohan", 30000, 20, 10, 2000);
        Employee e2 = new Employee("Sneha", 45000, 15, 12, 3000);

        System.out.println("Details for Employee 1:");
        e1.displayDetails();
        System.out.println();

        System.out.println("Details for Employee 2:");
        e2.displayDetails();

        System.out.println();
        System.out.printf("%s's gross = %.2f%n", e1.getName(), e1.calculateGross());
        System.out.printf("%s's gross = %.2f%n", e2.getName(), e2.calculateGross());
    }
}
