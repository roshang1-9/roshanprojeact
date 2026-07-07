package assignmentjava;

public class dowhileloopex1 {
	public static void main(String[] args) {
		java.util.Scanner sc=new java.util.Scanner(System.in);
		String choice;
		do {
			System.out.print("Enter a number: ");
			int n = sc.nextInt();
			System.out.println("Square of " + n + " is " + (n * n));

			System.out.print("Want another square? (yes/no): ");
			choice = sc.next();
		} while (choice.equalsIgnoreCase("yes"));

		sc.close();
	}

}
