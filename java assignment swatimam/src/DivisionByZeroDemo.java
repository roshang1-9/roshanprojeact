import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Demonstrates exception handling for division by zero.
 * Shows integer division (throws ArithmeticException) and double division behavior.
 */
public class DivisionByZeroDemo {

    public static void main(String[] args) {
        System.out.println("--- Division by Zero Demo ---\n");

        // Integer division examples (will throw ArithmeticException when divisor is 0)
        int[][] intTests = { {10, 2}, {10, 0}, {7, -1} };
        System.out.println("Integer division examples:");
        for (int[] t : intTests) {
            int a = t[0];
            int b = t[1];
            try {
                int r = a / b; // may throw ArithmeticException
                System.out.printf("%d / %d = %d%n", a, b, r);
            } catch (ArithmeticException ex) {
                System.out.printf("Caught ArithmeticException when dividing %d by %d: %s%n", a, b, ex.getMessage());
            } finally {
                System.out.println("Completed attempt for " + a + " and " + b + "\n");
            }
        }

        // Double division: dividing by zero yields Infinity or NaN but does not throw
        System.out.println("Double division examples (no exception thrown):");
        double[][] dblTests = { {10.0, 2.0}, {10.0, 0.0}, {0.0, 0.0} };
        for (double[] t : dblTests) {
            double a = t[0];
            double b = t[1];
            double r = a / b; // for b==0.0 gives Infinity or NaN
            if (Double.isInfinite(r)) {
                System.out.printf("%f / %f = %s (infinite result)\n", a, b, r);
            } else if (Double.isNaN(r)) {
                System.out.printf("%f / %f = NaN (undefined)\n", a, b);
            } else {
                System.out.printf("%f / %f = %f\n", a, b, r);
            }
        }

        // Interactive demonstration: handle user-provided integers
        System.out.println("\nInteractive demo: enter two integers to divide (int division)");
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter numerator (int): ");
            int num = sc.nextInt();
            System.out.print("Enter denominator (int): ");
            int den = sc.nextInt();
            try {
                int res = num / den;
                System.out.printf("Result: %d / %d = %d%n", num, den, res);
            } catch (ArithmeticException ex) {
                System.out.println("Error: Division by zero is not allowed (caught ArithmeticException).");
            }
        } catch (InputMismatchException ime) {
            System.out.println("Invalid input. Please enter integers.");
        } finally {
            sc.close();
        }

        System.out.println("\n--- Demo complete ---");
    }
}
