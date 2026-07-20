/**
 * Demonstrates constructor overloading to create Box objects and calculate their volumes.
 *
 * Constructors provided:
 * - Box()                : default 1x1x1 box
 * - Box(double side)     : cube with given side
 * - Box(double l,w,h)    : box with given length, width, height
 * - Box(Box other)       : copy constructor
 */
public class BoxVolume {

    static class Box {
        private double length;
        private double width;
        private double height;

        // Default constructor (1x1x1)
        public Box() {
            this(1.0, 1.0, 1.0);
        }

        // Cube constructor
        public Box(double side) {
            this(side, side, side);
        }

        // Constructor with all dimensions
        public Box(double length, double width, double height) {
            this.length = length;
            this.width = width;
            this.height = height;
        }

        // Copy constructor
        public Box(Box other) {
            this(other.length, other.width, other.height);
        }

        public double volume() {
            return length * width * height;
        }

        @Override
        public String toString() {
            return String.format("Box(%.2f x %.2f x %.2f)", length, width, height);
        }
    }

    public static void main(String[] args) {
        System.out.println("Constructor overloading - Box volume examples\n");

        Box defaultBox = new Box();
        System.out.println(defaultBox + " -> volume = " + defaultBox.volume());

        Box cube = new Box(3); // 3x3x3 cube
        System.out.println(cube + " -> volume = " + cube.volume());

        Box rectangular = new Box(2.5, 4.0, 1.5);
        System.out.println(rectangular + " -> volume = " + rectangular.volume());

        Box copy = new Box(rectangular);
        System.out.println(copy + " (copy of rectangular) -> volume = " + copy.volume());

        // show that integer arguments work too
        Box fromInts = new Box(2, 3, 4);
        System.out.println(fromInts + " -> volume = " + fromInts.volume());
    }
}
