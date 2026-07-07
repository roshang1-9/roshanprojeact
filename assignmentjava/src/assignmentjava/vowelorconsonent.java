package assignmentjava;

public class vowelorconsonent {
	public static void main(String[] args) {
		char ch = 'A';

		if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' ||
		    ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
			System.out.println(ch + " is a vowel.");
		} else if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
			System.out.println(ch + " is a consonant.");
		} else {
			System.out.println(ch + " is not an alphabet.");
		}
	}

}
