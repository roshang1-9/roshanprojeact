import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 * Calculates the additional amount given a base amount and a percentage,
 * and prints the additional amount and the new total.
 *
 * Example:
 * Enter base amount: 100
 * Enter percentage (e.g. 10 for 10%): 15
 * Additional amount: 15.00
 * New total: 115.00
 */
public class AdditionalAmount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        try {
            System.out.print("Enter base amount: ");
            double base = sc.nextDouble();
            System.out.print("Enter percentage (e.g. 10 for 10%): ");
            double percent = sc.nextDouble();

            double additional = base * percent / 100.0;
            double total = base + additional;

            System.out.printf(Locale.US, "Additional amount: %.2f%n", additional);
            System.out.printf(Locale.US, "New total: %.2f%n", total);
        } catch (InputMismatchException ime) {
            System.out.println("Invalid input. Please enter numeric values (use '.' for decimals).");
        } finally {
            sc.close();
        }
    }
}
