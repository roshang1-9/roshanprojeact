package assignmentjava;

public class swapusingthird {
	public static void main(String[] args) {
		System.out.println("enter two numbers");
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int a = sc.nextInt(), b = sc.nextInt();
		int c;
		c = a;
		a = b;
		b = c;
		System.out.println("after swapping a is " + a + " and b is " + b);
		sc.close();
	}

}
