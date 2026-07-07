package assignmentjava;
//check whether the point lies on  x-axis,or y-axis or origin:
//values of point given by user can be taken by using scanner class 
public class findpoint {
	public static void main(String[] args) {
		int x = 0; // Change this value to test different points
		int y = 0; // Change this value to test different points

		if (x == 0 && y == 0) {
			System.out.println("The point (" + x + ", " + y + ") lies on the origin.");
		} else if (x == 0) {
			System.out.println("The point (" + x + ", " + y + ") lies on the y-axis.");
		} else if (y == 0) {
			System.out.println("The point (" + x + ", " + y + ") lies on the x-axis.");
		} else {
			System.out.println("The point (" + x + ", " + y + ") does not lie on the x-axis, y-axis, or origin.");
		}
	}
}
