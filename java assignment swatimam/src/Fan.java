/**
 * Simple Fan class with attributes speed and isOn, and a method to display status.
 */
public class Fan {
    // possible speed values: 1 (low), 2 (medium), 3 (high)
    private int speed;
    private boolean isOn;

    public Fan() {
        this.speed = 1;
        this.isOn = false;
    }

    public Fan(int speed, boolean isOn) {
        this.speed = speed;
        this.isOn = isOn;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if (speed < 1) speed = 1;
        if (speed > 3) speed = 3;
        this.speed = speed;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    /**
     * Display current status of the fan to the console.
     */
    public void displayStatus() {
        if (isOn) {
            String speedName;
            switch (speed) {
                case 1: speedName = "Low"; break;
                case 2: speedName = "Medium"; break;
                case 3: speedName = "High"; break;
                default: speedName = "Unknown"; break;
            }
            System.out.println("Fan is ON - Speed: " + speed + " (" + speedName + ")");
        } else {
            System.out.println("Fan is OFF");
        }
    }
}
