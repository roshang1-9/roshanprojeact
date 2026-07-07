package assignmentjava;
//value  given and perform arithmetic operation using switch case:
public class arithmeticusingswitch {
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 5;
		char operator = '+'; // Change this to '-', '*', or '/' for different operations
		int result;

		switch (operator) {
			case '+':
				result = num1 + num2;
				System.out.println("Result: " + result);
				break;
			case '-':
				result = num1 - num2;
				System.out.println("Result: " + result);
				break;
			case '*':
				result = num1 * num2;
				System.out.println("Result: " + result);
				break;
			case '/':
				if (num2 != 0) {
					result = num1 / num2;
					System.out.println("Result: " + result);
				} else {
					System.out.println("Error: Division by zero is not allowed.");
				}
				break;
			default:
				System.out.println("Invalid operator. Please use +, -, *, or /.");
		}
	}

}
