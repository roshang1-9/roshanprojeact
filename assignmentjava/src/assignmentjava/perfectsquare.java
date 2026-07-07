/**
 * 
 */
package assignmentjava;

/**
 * 
 */
public class perfectsquare {
	public static void main(String[] args) {
		int num = 16;
		double sqrt = Math.sqrt(num);

		if (sqrt == (int) sqrt) {
			System.out.println(num + " is a perfect square.");
		} else {
			System.out.println(num + " is not a perfect square.");
		}
	}
}