package assignmentjava;

public class uppercaseorlowercase {
	public static void main(String[] args) {
		char ch = 'A';

		if (ch >= 'A' && ch <= 'Z') {
			System.out.println(ch + " is an uppercase letter.");
		} else if (ch >= 'a' && ch <= 'z') {
			System.out.println(ch + " is a lowercase letter.");
		} else {
			System.out.println(ch + " is not an alphabetic character.");
		}
	}

}
