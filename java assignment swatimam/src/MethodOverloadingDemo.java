/**
 * Demonstrates method overloading in Java.
 * Several "area" and "add" methods are overloaded with different parameter lists.
 */
public class MethodOverloadingDemo {

    // Overloaded method: area of a square
    public static double area(double side) {
        return side * side;
    }

    // Overloaded method: area of rectangle
    public static double area(double length, double width) {
        return length * width;
    }

    // Overloaded method: area of circle (radius)
    public static double areaCircle(double radius) {
        return Math.PI * radius * radius;
    }

    // Overloaded "add" methods
    public static int add(int a, int b) {
        return a + b;
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    // Overloaded method with varargs
    public static int add(int... nums) {
        int s = 0;
        for (int x : nums) s += x;
        return s;
    }

    // Overloaded methods that differ by parameter types
    public static String describe(int x) { return "int: " + x; }
    public static String describe(String s) { return "String: " + s; }

    public static void main(String[] args) {
        System.out.println("--- Method Overloading Demo ---\n");

        System.out.printf("Area of square (side=4) = %.2f%n", area(4));
        System.out.printf("Area of rectangle (4 x 5) = %.2f%n", area(4, 5));
        System.out.printf("Area of circle (r=3) = %.2f%n", areaCircle(3));

        System.out.println();
        System.out.println("add(int,int) = " + add(2, 3));
        System.out.println("add(double,double) = " + add(2.5, 3.1));
        System.out.println("add(int,int,int) = " + add(1, 2, 3));
        System.out.println("add(varargs) = " + add(1,2,3,4,5));

        System.out.println();
        System.out.println(describe(10));
        System.out.println(describe("hello"));

        System.out.println("\nNotes: Java chooses the correct overloaded method based on argument types and count.");
        System.out.println("If multiple methods match, the most specific one is chosen (compile-time resolution).");

        System.out.println("\n--- End ---");
    }
}
