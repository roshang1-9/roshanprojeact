package assignmentjava;

public class absolutevalueusingterniary {
	public static void main(String[] args) {
		System.out.println("enter a number");
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int num = sc.nextInt();
		int absValue = (num >= 0) ? num : -num;
		System.out.println("the absolute value of " + num + " is " + absValue);
		sc.close();
	}

}
