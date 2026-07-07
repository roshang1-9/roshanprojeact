package assignmentjava;

public class givenvaluefindabsolute {
	public static void main(String[] args) {
		int number = -5;
		int absoluteValue;

		if (number < 0) {
			absoluteValue = -number; // Negate the number to get its absolute value
		} else {
			absoluteValue = number; // The number is already non-negative
		}

		System.out.println("The absolute value of " + number + " is: " + absoluteValue);
	}

}
