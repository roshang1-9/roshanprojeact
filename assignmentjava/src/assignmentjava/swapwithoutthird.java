package assignmentjava;

public class swapwithoutthird {
	public static void main(String[] args) {
		System.out.println("enter two numbers");
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int a = sc.nextInt(), b = sc.nextInt();
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("after swapping a is " + a + " and b is " + b);
		sc.close();
	}

}
