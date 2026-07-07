package assignmentjava;
//km to m,m to cm,cm to mm
//values are taken usingscanner class from user and then converted to other units using switch case statement
public class switchtoconvertunits {
	public static void main(String[] args) {
		java.util.Scanner sc=new java.util.Scanner();
		int choice = sc.nextInt(); // Change this value to test different choices
		double value = 5.0; // Change this value to test different input values

		switch (choice) {
			case 1:
				double meters = value * 1000;
				System.out.println(value + " kilometers is equal to " + meters + " meters.");
				break;
			case 2:
				double centimeters = value * 100;
				System.out.println(value + " meters is equal to " + centimeters + " centimeters.");
				break;
			case 3:
				double millimeters = value * 10;
				System.out.println(value + " centimeters is equal to " + millimeters + " millimeters.");
				break;
			default:
				System.out.println("Invalid choice. Please select a valid option.");
		}
	}
}
