package assignmentjava;

public class areacircumcircle {
	public static void main(String[] args) {
		System.out.println("enter the radius");
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int r = sc.nextInt();
				double area = 3.14 * r * r;
				double circum = 2 * 3.14 * r;
				System.out.println("area is " + area);
				System.out.println("circumference is " + circum);
				
	}
	

}
