/**
 * Employee class that calculates Gross salary.
 * Gross = basic + HRA + DA + allowances
 * where HRA and DA are percentages of basic.
 */
public class Employee {
    private String name;
    private double basicSalary;
    private double hraPercent; // e.g., 20 for 20%
    private double daPercent;  // e.g., 10 for 10%
    private double allowances; // fixed amount

    public Employee(String name, double basicSalary, double hraPercent, double daPercent, double allowances) {
        if (name == null) name = "";
        if (basicSalary < 0) throw new IllegalArgumentException("basicSalary cannot be negative");
        if (hraPercent < 0) throw new IllegalArgumentException("hraPercent cannot be negative");
        if (daPercent < 0) throw new IllegalArgumentException("daPercent cannot be negative");
        if (allowances < 0) throw new IllegalArgumentException("allowances cannot be negative");
        this.name = name;
        this.basicSalary = basicSalary;
        this.hraPercent = hraPercent;
        this.daPercent = daPercent;
        this.allowances = allowances;
    }

    public String getName() { return name; }
    public double getBasicSalary() { return basicSalary; }
    public double getHraPercent() { return hraPercent; }
    public double getDaPercent() { return daPercent; }
    public double getAllowances() { return allowances; }

    public void setName(String name) { this.name = name; }
    public void setBasicSalary(double basicSalary) { if (basicSalary < 0) throw new IllegalArgumentException("basicSalary cannot be negative"); this.basicSalary = basicSalary; }
    public void setHraPercent(double hraPercent) { if (hraPercent < 0) throw new IllegalArgumentException("hraPercent cannot be negative"); this.hraPercent = hraPercent; }
    public void setDaPercent(double daPercent) { if (daPercent < 0) throw new IllegalArgumentException("daPercent cannot be negative"); this.daPercent = daPercent; }
    public void setAllowances(double allowances) { if (allowances < 0) throw new IllegalArgumentException("allowances cannot be negative"); this.allowances = allowances; }

    public double calculateHra() {
        return basicSalary * hraPercent / 100.0;
    }

    public double calculateDa() {
        return basicSalary * daPercent / 100.0;
    }

    /**
     * Calculates gross salary: basic + HRA + DA + allowances
     */
    public double calculateGross() {
        return basicSalary + calculateHra() + calculateDa() + allowances;
    }

    public void displayDetails() {
        System.out.println("Employee: " + name);
        System.out.printf("Basic Salary: %.2f%n", basicSalary);
        System.out.printf("HRA (%.2f%%): %.2f%n", hraPercent, calculateHra());
        System.out.printf("DA (%.2f%%): %.2f%n", daPercent, calculateDa());
        System.out.printf("Allowances: %.2f%n", allowances);
        System.out.printf("Gross Salary: %.2f%n", calculateGross());
    }
}
