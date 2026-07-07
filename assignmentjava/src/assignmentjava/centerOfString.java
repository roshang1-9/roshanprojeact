package assignmentjava;

/**
 * Read a string from the user and print its center character(s).
 * If the length is odd, prints the single middle character.
 * If it's even, prints the two middle characters.
 */
public class centerOfString {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        if (s == null || s.length() == 0) {
            System.out.println("Empty string.");
            return;
        }

        String center = getCenter(s);
        System.out.println("Center of '" + s + "' -> " + center);
    }

    /**
     * Return the center character(s) of the given string.
     * For odd length returns a single char string; for even length returns two chars.
     */
    public static String getCenter(String s) {
        int len = s.length();
        if (len % 2 == 1) {
            return String.valueOf(s.charAt(len / 2));
        } else {
            return s.substring(len / 2 - 1, len / 2 + 1);
        }
    }
}
