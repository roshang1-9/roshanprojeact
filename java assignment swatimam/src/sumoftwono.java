import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Simple program that accepts two numbers from the user and prints their sum.
 * Accepts integers or decimal numbers.
 */
public class sumoftwono {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first number:");
		try {
			double a = sc.nextDouble();
			System.out.println("Enter the second number:");
			double b = sc.nextDouble();
			double sum = a + b;
			// If both inputs were integers (no fractional part), print as integer
			if (a == Math.rint(a) && b == Math.rint(b)) {
				long isum = (long) (a + b);
				System.out.println("Sum (integer): " + isum);
			} else {
				System.out.println("Sum: " + sum);
			}
		} catch (InputMismatchException ime) {
			System.out.println("Invalid input. Please enter numeric values.");
		} finally {
			sc.close();
		}
	}
}

