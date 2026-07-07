package assignmentjava;
//count the number of digits in a given number  by scanner class and then print the count of digits
public class countdigits {
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.println("enter numbers");
		int number = sc.nextInt();
		// Change this value to test with different numbers
		int count = 0;
		
		while (number != 0) {
			number /= 10; // Remove the last digit
			count++; // Increment the count of digits
		}
		
		System.out.println("The number of digits is: " + count);
	}
	
	

}
