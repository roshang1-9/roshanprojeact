package assignmentjava;

public class noofweeksandremainday {
	public static void main(String[] args) {
		System.out.println("enter the number of days");
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int days = sc.nextInt();
		int weeks = days / 7;
		int remdays = days % 7;
		System.out.println(days + " days are " + weeks + " weeks and " + remdays + " days");
		sc.close();
	}

}
