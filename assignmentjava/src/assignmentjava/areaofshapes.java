package assignmentjava;
//using switch calculate area of circle ,square ,rectangle and triangle:
public class areaofshapes {
	public static void main(String[] args) {
		int shape = 1; // 1 for circle, 2 for square, 3 for rectangle, 4 for triangle
		double area = 0.0;

		switch (shape) {
			case 1: // Circle
				double radius = 5.0;
				area = Math.PI * radius * radius;
				System.out.println("Area of the circle: " + area);
				break;
			case 2: // Square
				double side = 4.0;
				area = side * side;
				System.out.println("Area of the square: " + area);
				break;
			case 3: // Rectangle
				double length = 6.0;
				double width = 3.0;
				area = length * width;
				System.out.println("Area of the rectangle: " + area);
				break;
			case 4: // Triangle
				double base = 5.0;
				double height = 4.0;
				area = 0.5 * base * height;
				System.out.println("Area of the triangle: " + area);
				break;
			default:
				System.out.println("Invalid shape selection.");
		}
	}
	

}
