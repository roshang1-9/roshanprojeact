package assignmentjava;

import java.util.Scanner;

/**
 * Find the median of three numbers using only numeric comparisons.
 * This implementation does not use arrays or string manipulation to compute the median.
 */
public class findMedianThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter three numbers separated by spaces: ");
        if (!sc.hasNextDouble()) { System.out.println("Invalid input"); return; }
        double a = sc.nextDouble();
        if (!sc.hasNextDouble()) { System.out.println("Invalid input"); return; }
        double b = sc.nextDouble();
        if (!sc.hasNextDouble()) { System.out.println("Invalid input"); return; }
        double c = sc.nextDouble();

        double median = medianOfThree(a, b, c);
        System.out.println(median);
    }

    public static double medianOfThree(double a, double b, double c) {
        // If a is between b and c, it's the median
        if ((a >= b && a <= c) || (a >= c && a <= b)) return a;
        // If b is between a and c, it's the median
        if ((b >= a && b <= c) || (b >= c && b <= a)) return b;
        // Otherwise c is the median
        return c;
    }
}
