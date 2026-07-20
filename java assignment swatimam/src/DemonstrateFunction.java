/**
 * Demonstrates functions (methods) in Java:
 * - static and instance methods
 * - method overloading
 * - return values
 * - recursion (factorial)
 * - varargs
 * - pass-by-value for primitives and object references
 */
public class DemonstrateFunction {

    // static method (can be called without creating an object)
    public static int add(int a, int b) {
        return a + b;
    }

    // overloaded static method for doubles
    public static double add(double a, double b) {
        return a + b;
    }

    // instance method
    public void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }

    // method returning boolean
    public boolean isEven(int n) {
        return n % 2 == 0;
    }

    // recursive method: factorial
    public long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    // varargs method: sum any number of arguments
    public static int sumAll(int... nums) {
        int s = 0;
        for (int x : nums) s += x;
        return s;
    }

    // demonstrate pass-by-value for primitive
    public static void tryToChangePrimitive(int x) {
        x = x + 10;
        System.out.println("Inside tryToChangePrimitive: x = " + x);
    }

    // simple mutable holder to demonstrate object reference behavior
    static class Holder {
        public int value;
        public Holder(int v) { this.value = v; }
    }

    // try to change object field
    public static void changeHolder(Holder h) {
        h.value = h.value + 10; // modifies the object referred to by caller's reference
        System.out.println("Inside changeHolder: holder.value = " + h.value);
    }

    public static void main(String[] args) {
        System.out.println("--- DemonstrateFunction program ---");

        // static add
        System.out.println("add(3,4) = " + add(3, 4));
        System.out.println("add(2.5, 3.1) = " + add(2.5, 3.1));

        // instance methods
        DemonstrateFunction df = new DemonstrateFunction();
        df.greet("Alice");
        System.out.println("isEven(5) = " + df.isEven(5));
        System.out.println("isEven(6) = " + df.isEven(6));

        // recursion
        System.out.println("factorial(5) = " + df.factorial(5));

        // varargs
        System.out.println("sumAll(1,2,3,4) = " + sumAll(1,2,3,4));

        // pass-by-value
        int original = 20;
        System.out.println("Before tryToChangePrimitive: original = " + original);
        tryToChangePrimitive(original);
        System.out.println("After tryToChangePrimitive: original = " + original);

        // object reference behavior
        Holder h = new Holder(30);
        System.out.println("Before changeHolder: holder.value = " + h.value);
        changeHolder(h);
        System.out.println("After changeHolder: holder.value = " + h.value);

        System.out.println("--- End ---");
    }
}
