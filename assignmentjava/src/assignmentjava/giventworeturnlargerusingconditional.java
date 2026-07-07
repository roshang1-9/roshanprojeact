package assignmentjava;

public class giventworeturnlargerusingconditional {
	public static void main(String[] args) {
		System.out.println("enter two numbers");
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int a = sc.nextInt(), b = sc.nextInt();
		int larger = (a > b) ? a : b;
		System.out.println("the larger number is " + larger);
		sc.close();
	}

}
