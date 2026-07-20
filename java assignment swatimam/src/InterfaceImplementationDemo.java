import java.util.Locale;
import java.util.Scanner;

/**
 * Demonstrates implementation of SquareCubeOps interface.
 */
public class InterfaceImplementationDemo implements SquareCubeOps {

    @Override
    public double square(double x) {
        return x * x;
    }

    @Override
    public double cube(double x) {
        return x * x * x;
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        InterfaceImplementationDemo impl = new InterfaceImplementationDemo();

        System.out.println("--- Interface implementation demo ---");

        double[] samples = {2, 3.5, -1};
        for (double s : samples) {
            System.out.printf("number=%.2f, square=%.2f, cube=%.2f%n", s, impl.square(s), impl.cube(s));
        }

        // Optional interactive part
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a number to compute square and cube (or non-number to skip): ");
        if (sc.hasNextDouble()) {
            double v = sc.nextDouble();
            System.out.printf("Square: %.4f%nCube: %.4f%n", impl.square(v), impl.cube(v));
        } else {
            System.out.println("Skipping interactive input.");
        }
        sc.close();

        System.out.println("--- End ---");
    }
}
