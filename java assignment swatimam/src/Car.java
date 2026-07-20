/**
 * Simple Car class that tracks speed and fuel level.
 *
 * Features:
 * - speed (km/h)
 * - fuelLevel (litres)
 * - accelerate and brake methods
 * - refuel method with tank capacity check
 * - displayStatus to show current values
 */
public class Car {
    private double speed; // km/h
    private double fuelLevel; // litres

    private final double tankCapacity; // litres
    private final double maxSpeed; // km/h

    // fuel consumption per km when accelerating (simple model lit/km)
    private final double consumptionPerKm;

    public Car() {
        this.speed = 0;
        this.fuelLevel = 0;
        this.tankCapacity = 50.0;
        this.maxSpeed = 200.0;
        this.consumptionPerKm = 0.08; // 8 L/100km
    }

    public Car(double initialFuel, double tankCapacity, double maxSpeed, double consumptionPerKm) {
        if (initialFuel < 0) throw new IllegalArgumentException("initialFuel cannot be negative");
        if (tankCapacity <= 0) throw new IllegalArgumentException("tankCapacity must be positive");
        if (maxSpeed <= 0) throw new IllegalArgumentException("maxSpeed must be positive");
        if (consumptionPerKm <= 0) throw new IllegalArgumentException("consumptionPerKm must be positive");
        this.fuelLevel = Math.min(initialFuel, tankCapacity);
        this.tankCapacity = tankCapacity;
        this.maxSpeed = maxSpeed;
        this.consumptionPerKm = consumptionPerKm;
        this.speed = 0;
    }

    public double getSpeed() { return speed; }
    public double getFuelLevel() { return fuelLevel; }
    public double getTankCapacity() { return tankCapacity; }
    public double getMaxSpeed() { return maxSpeed; }

    /**
     * Accelerate by delta km/h. Consumes fuel based on a simple model that
     * uses delta to estimate distance traveled (approx) — this is just for demo.
     * If there's not enough fuel, acceleration will be limited.
     */
    public void accelerate(double delta) {
        if (delta <= 0) return;
        double targetSpeed = Math.min(maxSpeed, speed + delta);
        double avgSpeed = (speed + targetSpeed) / 2.0;
        // estimate 1 km traveled for every 10 km/h increase (toy model)
        double estimatedKm = Math.abs(targetSpeed - speed) / 10.0;
        double fuelNeeded = estimatedKm * consumptionPerKm;
        if (fuelNeeded > fuelLevel) {
            // not enough fuel to reach target; scale down
            double possibleKm = fuelLevel / consumptionPerKm;
            double possibleDelta = possibleKm * 10.0; // inverse of estimate
            targetSpeed = Math.min(maxSpeed, speed + possibleDelta);
            fuelNeeded = fuelLevel; // consume remaining fuel
        }
        speed = targetSpeed;
        fuelLevel = Math.max(0.0, fuelLevel - fuelNeeded);
    }

    /**
     * Brake by delta km/h (reduce speed). Speed cannot go below 0.
     */
    public void brake(double delta) {
        if (delta <= 0) return;
        speed = Math.max(0.0, speed - delta);
    }

    /**
     * Refuel by amount litres. Returns actual amount added.
     */
    public double refuel(double amount) {
        if (amount <= 0) return 0.0;
        double space = tankCapacity - fuelLevel;
        double added = Math.min(space, amount);
        fuelLevel += added;
        return added;
    }

    public void displayStatus() {
        System.out.printf("Car status: speed=%.1f km/h, fuelLevel=%.2f L (tankCapacity=%.2f L)\n", speed, fuelLevel, tankCapacity);
    }

    @Override
    public String toString() {
        return String.format("Car[speed=%.1f km/h, fuel=%.2f/%.2f L]", speed, fuelLevel, tankCapacity);
    }
}
