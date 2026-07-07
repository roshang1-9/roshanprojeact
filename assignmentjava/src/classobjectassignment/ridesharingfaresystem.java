package classobjectassignment;

import java.util.Scanner;

public class ridesharingfaresystem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter customer name: ");
		String customer = sc.nextLine();

		System.out.print("Enter distance travelled (km): ");
		double distance = readDouble(sc);

		System.out.print("Enter price per km: ");
		double pricePerKm = readDouble(sc);

		System.out.print("Enter surge multiplier: ");
		double surge = readDouble(sc);

		Ride ride = new Ride(customer, distance, pricePerKm, surge);

		System.out.println();
		System.out.println(ride);

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

}

class Ride {
	private String customerName;
	private double distanceTravelled;
	private double pricePerKm;
	private double surgeMultiplier;

	// service charge when surge > 1.5
	private static final double SERVICE_CHARGE = 50.0;

	public Ride(String customerName, double distanceTravelled, double pricePerKm, double surgeMultiplier) {
		this.customerName = customerName;
		this.distanceTravelled = distanceTravelled;
		this.pricePerKm = pricePerKm;
		this.surgeMultiplier = surgeMultiplier;
	}

	// Getters
	public String getCustomerName() {
		return customerName;
	}

	public double getDistanceTravelled() {
		return distanceTravelled;
	}

	public double getPricePerKm() {
		return pricePerKm;
	}

	public double getSurgeMultiplier() {
		return surgeMultiplier;
	}

	// base fare before any discounts or service charges
	public double getBaseFare() {
		return getDistanceTravelled() * getPricePerKm();
	}

	// Apply 10% discount on base fare if distance > 20 km
	public double getDiscountedBaseFare() {
		double base = getBaseFare();
		if (getDistanceTravelled() > 20.0) {
			return base * 0.90; // 10% discount
		}
		return base;
	}

	// final fare = discountedBaseFare * surgeMultiplier, plus service charge if surge > 1.5
	public double getFinalFare() {
		double fare = getDiscountedBaseFare() * getSurgeMultiplier();
		if (getSurgeMultiplier() > 1.5) {
			fare += SERVICE_CHARGE;
		}
		return fare;
	}

	@Override
	public String toString() {
		return String.format("Customer: %s\nDistance: %.2f km, Price/km: %.2f, Surge: %.2f\nBase fare: %.2f, Discounted base: %.2f, Final fare: %.2f",
				getCustomerName(), getDistanceTravelled(), getPricePerKm(), getSurgeMultiplier(), getBaseFare(), getDiscountedBaseFare(), getFinalFare());
	}
}
