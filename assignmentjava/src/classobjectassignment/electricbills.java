package classobjectassignment;

import java.util.Scanner;

public class electricbills {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			ElectricityBill bill = new ElectricityBill();

			System.out.print("Enter customer name: ");
			String name = sc.nextLine().trim();
			bill.setCustomerName(name);

			// Read units consumed (non-negative)
			double units = -1.0;
			while (units < 0) {
				System.out.print("Enter units consumed (non-negative number): ");
				if (sc.hasNextDouble()) {
					units = sc.nextDouble();
					if (units < 0) {
						System.out.println("Units cannot be negative. Please try again.");
					}
				} else {
					System.out.println("Invalid input. Please enter a numeric value.");
					sc.next();
				}
			}
			bill.setUnitsConsumed(units);

			// Read price per unit (non-negative)
			double price = -1.0;
			while (price < 0) {
				System.out.print("Enter price per unit (non-negative number): ");
				if (sc.hasNextDouble()) {
					price = sc.nextDouble();
					if (price < 0) {
						System.out.println("Price per unit cannot be negative. Please try again.");
					}
				} else {
					System.out.println("Invalid input. Please enter a numeric value.");
					sc.next();
				}
			}
			bill.setPricePerUnit(price);

			System.out.println();
			System.out.println("Customer Name: " + bill.getCustomerName());
			System.out.printf("Units Consumed: %.2f%n", bill.getUnitsConsumed());
			System.out.printf("Price Per Unit: %.2f%n", bill.getPricePerUnit());
			System.out.printf("Total Bill: %.2f%n", bill.getTotalBill());
		}
	}

}

class ElectricityBill {
	private String customerName;
	private double unitsConsumed;
	private double pricePerUnit;

	// Setters
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setUnitsConsumed(double unitsConsumed) {
		this.unitsConsumed = unitsConsumed;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	// Getters
	public String getCustomerName() {
		return customerName;
	}

	public double getUnitsConsumed() {
		return unitsConsumed;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	// Getter that calculates total bill; adds 10% if units > 500
	public double getTotalBill() {
		double total = unitsConsumed * pricePerUnit;
		if (unitsConsumed > 500) {
			total = total + (total * 10.0 / 100.0);
		}
		return total;
	}
}
