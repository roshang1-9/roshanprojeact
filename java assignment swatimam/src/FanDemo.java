/**
 * Demo class to create two Fan objects and display their status.
 */
public class FanDemo {
    public static void main(String[] args) {
        // Create first fan: ON at high speed
        Fan fan1 = new Fan(3, true);

        // Create second fan: default (OFF)
        Fan fan2 = new Fan();

        System.out.println("Fan 1 status:");
        fan1.displayStatus();

        System.out.println("\nFan 2 status:");
        fan2.displayStatus();

        // Change fan2 to ON and set speed
        fan2.setOn(true);
        fan2.setSpeed(2);
        System.out.println("\nFan 2 status after turning on and setting speed:");
        fan2.displayStatus();
    }
}
