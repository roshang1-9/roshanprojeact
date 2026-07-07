package classobjectassignment;

import java.util.Scanner;

public class employeebonussystem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter employee name: ");
		String name = sc.nextLine();

		System.out.print("Enter salary: ");
		double salary = readDouble(sc);

		System.out.print("Enter years of service: ");
		int years = readInt(sc);

		Employee emp = new Employee(name, salary, years);

		System.out.println();
		System.out.println(emp);

		sc.close();
	}

	private static double readDouble(Scanner sc) {
		while (true) {
			try {
				String token = sc.next();
				return Double.parseDouble(token);
			} catch (NumberFormatException e) {
				System.out.print("Invalid number, please enter again: ");
			}
		}
	}

	private static int readInt(Scanner sc) {
		while (true) {
			try {
				String token = sc.next();
				return Integer.parseInt(token);
			} catch (NumberFormatException e) {
				System.out.print("Invalid integer, please enter again: ");
			}
		}
	}

}

class Employee {
	private String employeeName;
	private double salary;
	private int yearsOfService;

	public Employee(String employeeName, double salary, int yearsOfService) {
		this.employeeName = employeeName;
		this.salary = salary;
		this.yearsOfService = yearsOfService;
	}

	// Getters
	public String getEmployeeName() {
		return employeeName;
	}

	public double getSalary() {
		return salary;
	}

	public int getYearsOfService() {
		return yearsOfService;
	}

	// Determine bonus percentage according to rules
	// >=10 years -> 20%, >=5 -> 10%, else 5%
	public double getBonusPercent() {
		if (yearsOfService >= 10) return 0.20;
		if (yearsOfService >= 5) return 0.10;
		return 0.05;
	}

	public double getBonusAmount() {
		return salary * getBonusPercent();
	}

	public double getFinalSalary() {
		return salary + getBonusAmount();
	}

	@Override
	public String toString() {
		return String.format("Employee: %s\nSalary: %.2f, Years of service: %d\nBonus: %.2f (%.0f%%), Final salary: %.2f",
				getEmployeeName(), getSalary(), getYearsOfService(), getBonusAmount(), getBonusPercent() * 100, getFinalSalary());
	}
}
