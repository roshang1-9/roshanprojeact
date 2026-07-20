public class CarDemo {
    public static void main(String[] args) {
        Car c1 = new Car(10.0, 50.0, 180.0, 0.08);
        Car c2 = new Car(); // default

        System.out.println("Initial states:");
        c1.displayStatus();
        c2.displayStatus();

        System.out.println("\nAccelerating car1 by 60 km/h...");
        c1.accelerate(60);
        c1.displayStatus();

        System.out.println("Braking car1 by 20 km/h...");
        c1.brake(20);
        c1.displayStatus();

        System.out.println("\nRefueling car2 by 20 L...");
        double added = c2.refuel(20);
        System.out.println("Added " + added + " L to car2");
        c2.displayStatus();

        System.out.println("\nAttempt to accelerate car2 by 30 km/h (should consume fuel)...");
        c2.accelerate(30);
        c2.displayStatus();
    }
}
