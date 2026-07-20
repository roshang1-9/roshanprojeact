/**
 * Demo for SmartLight showing basic operations.
 */
public class SmartLightDemo {
    public static void main(String[] args) {
        SmartLight light1 = new SmartLight();
        SmartLight light2 = new SmartLight(false, 40);

        System.out.println("Initial states:");
        light1.displayStatus();
        light2.displayStatus();

        System.out.println("\nTurning on light2 and increasing brightness by 30:");
        light2.turnOn();
        light2.increaseBrightness(30);
        light2.displayStatus();

        System.out.println("\nDimming light1 by 50 and toggling:");
        light1.decreaseBrightness(50);
        light1.toggle();
        light1.displayStatus();

        System.out.println("\nSet light1 brightness to 120 (should clamp to 100):");
        light1.setBrightness(120);
        light1.displayStatus();
    }
}
