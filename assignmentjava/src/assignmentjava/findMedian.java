package assignmentjava;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Read n numbers from the user and print their median.
 * Supports decimal numbers.
 */
public class findMedian {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many numbers? ");
        int n;
        try {
            n = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid count. Please enter an integer.");
            return;
        }

        if (n <= 0) {
            System.out.println("Count must be positive.");
            return;
        }

        double[] arr = new double[n];
        System.out.println("Enter " + n + " number(s) (separated by spaces or newlines):");
        for (int i = 0; i < n; i++) {
            if (sc.hasNextDouble()) {
                arr[i] = sc.nextDouble();
            } else {
                // If the next token isn't a double, try to recover or exit.
                System.out.println("Invalid or insufficient numeric input.");
                return;
            }
        }

        double median = medianOf(arr);
        System.out.println("Median: " + median);
    }

    public static double medianOf(double[] a) {
        double[] copy = Arrays.copyOf(a, a.length);
        Arrays.sort(copy);
        int n = copy.length;
        if (n % 2 == 1) {
            return copy[n / 2];
        } else {
            return (copy[n / 2 - 1] + copy[n / 2]) / 2.0;
        }
    }
}
