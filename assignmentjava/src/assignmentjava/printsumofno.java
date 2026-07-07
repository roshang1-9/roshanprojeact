package assignmentjava;
// print the sum of numbers from 1 to n using a for loop
// and print the full calculation, e.g. 1+2+3+4+5=15
public class printsumofno {
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.print("Enter a number: ");
		int n = sc.nextInt();

		if (n <= 0) {
			System.out.println("Please enter a positive integer.");
			sc.close();
			return;
		}

		int sum = 0;
		// Print the sequence as we compute the sum to avoid using StringBuilder
		for (int i = 1; i <= n; i++) {
			sum += i;
			if (i < n) {
				System.out.print(i + "+");
			} else {
				System.out.print(i);
			}
		}
		// print the equals and result
		System.out.println("=" + sum);
		sc.close();
	}
}