package assignmentjava;

public class alphabetorvowel {
	public static void main(String[] args) {
		char ch = 'A';

		if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
			if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' ||
			    ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				System.out.println(ch + " is a vowel.");
			} else {
				System.out.println(ch + " is a consonant.");
			}
		} else {
			System.out.println(ch + " is not an alphabetic character.");
		}
	}

}
