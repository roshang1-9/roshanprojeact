package assignmentjava;

public class findevenoroddusingconditional {
	public static void main(String[] args) {
		System.out.println("enter a number");
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int num = sc.nextInt();
		if (num % 2 == 0) {
			System.out.println(num + " is even");
		} else {
			System.out.println(num + " is odd");
		}
		sc.close();
	}

}
