package classobjectassignment;

import java.util.Scanner;

public class hotelroombooking {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter guest name: ");
		String guest = sc.nextLine();

		System.out.print("Enter room price per night: ");
		double price = readDouble(sc);

		System.out.print("Enter number of nights: ");
		int nights = readInt(sc);

		HotelBooking booking = new HotelBooking(guest, price, nights);

		System.out.println();
		System.out.println(booking);

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

class HotelBooking {
	private String guestName;
	private double roomPricePerNight;
	private int numberOfNights;

	public HotelBooking(String guestName, double roomPricePerNight, int numberOfNights) {
		this.guestName = guestName;
		this.roomPricePerNight = roomPricePerNight;
		this.numberOfNights = numberOfNights;
	}

	// Getters
	public String getGuestName() {
		return guestName;
	}

	public double getRoomPricePerNight() {
		return roomPricePerNight;
	}

	public int getNumberOfNights() {
		return numberOfNights;
	}

	// Subtotal without discount
	public double getSubtotal() {
		return getRoomPricePerNight() * getNumberOfNights();
	}

	// Total bill after discount if applicable. If nights >= 7, give 15% discount.
	public double getTotalBill() {
		double subtotal = getSubtotal();
		if (getNumberOfNights() >= 7) {
			return subtotal * 0.85; // 15% discount
		}
		return subtotal;
	}

	@Override
	public String toString() {
		return String.format("Guest: %s\nPrice per night: %.2f, Nights: %d\nSubtotal: %.2f, Total(after discount if any): %.2f",
				getGuestName(), getRoomPricePerNight(), getNumberOfNights(), getSubtotal(), getTotalBill());
	}
}
