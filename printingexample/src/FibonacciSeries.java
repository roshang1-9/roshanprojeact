public class FibonacciSeries {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter number of terms : ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid input. Please enter a positive integer.");
            sc.close();
            return;
        }
        int n = sc.nextInt();
        sc.close();
        if (n <= 0) {
        			System.out.println("Please enter a positive integer.");
        							return;
        } else if (n == 1) {
        			System.out.println("0");
        } else if (n == 2) {
					System.out.println("0 1");
		} else {
					System.out.println("Fibonacci series up to " + n + " terms:");
            // Print iteratively to avoid recursion overhead
            int a = 0, b = 1;
            System.out.print(a + " " + b);
            for (int i = 3; i <= n; i++) {
                int next = a + b;
                System.out.print(" " + next);
                a = b;
                b = next;
            }
            System.out.println();
        }
    }
}
