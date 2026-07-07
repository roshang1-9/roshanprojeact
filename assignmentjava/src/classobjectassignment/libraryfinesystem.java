package classobjectassignment;

import java.util.Scanner;

public class libraryfinesystem {

	// Reads input and displays fine details
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter book name: ");
		String bookName = sc.nextLine();

		System.out.print("Enter days late: ");
		int daysLate = readInt(sc);

		System.out.print("Enter fine per day: ");
		double finePerDay = readDouble(sc);

		LibraryBook book = new LibraryBook(bookName, daysLate, finePerDay);

		System.out.println();
		System.out.println(book);

		sc.close();
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

class LibraryBook {
	private String bookName;
	private int daysLate;
	private double finePerDay;

	// When daysLate > 10, we add a flat penalty of 100.0
	private static final double EXTRA_PENALTY = 100.0;

	public LibraryBook(String bookName, int daysLate, double finePerDay) {
		this.bookName = bookName;
		this.daysLate = daysLate;
		this.finePerDay = finePerDay;
	}

	// Getters
	public String getBookName() {
		return bookName;
	}

	public int getDaysLate() {
		return daysLate;
	}

	public double getFinePerDay() {
		return finePerDay;
	}

	// basic total fine
	public double getTotalFine() {
		return getDaysLate() * getFinePerDay();
	}

	// final fine after applying extra rule: if daysLate > 10 add flat penalty
	public double getFinalFine() {
		double total = getTotalFine();
		if (getDaysLate() > 10) {
			total += EXTRA_PENALTY;
		}
		return total;
	}

	@Override
	public String toString() {
		return String.format("Book: %s\nDays late: %d, Fine/day: %.2f\nTotal fine: %.2f, Final fine (after extra if any): %.2f",
				getBookName(), getDaysLate(), getFinePerDay(), getTotalFine(), getFinalFine());
	}
}
