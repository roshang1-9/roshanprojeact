/**
 * SmartLight models a simple smart light with adjustable brightness.
 * Brightness is an integer in the range [0,100]. When the light is off,
 * brightness is remembered but the light is not emitting.
 */
public class SmartLight {
    private boolean isOn;
    private int brightness; // 0..100

    public SmartLight() {
        this.isOn = false;
        this.brightness = 100; // default full brightness when turned on
    }

    public SmartLight(boolean isOn, int brightness) {
        this.isOn = isOn;
        setBrightness(brightness);
    }

    public boolean isOn() {
        return isOn;
    }

    public int getBrightness() {
        return brightness;
    }

    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }

    public void toggle() {
        isOn = !isOn;
    }

    /**
     * Set brightness to value in [0,100]. If value is outside range it will be clamped.
     */
    public void setBrightness(int value) {
        if (value < 0) value = 0;
        if (value > 100) value = 100;
        this.brightness = value;
    }

    /**
     * Increase brightness by delta (clamped to 100).
     */
    public void increaseBrightness(int delta) {
        setBrightness(this.brightness + delta);
    }

    /**
     * Decrease brightness by delta (clamped to 0).
     */
    public void decreaseBrightness(int delta) {
        setBrightness(this.brightness - delta);
    }

    public void displayStatus() {
        String state = isOn ? "ON" : "OFF";
        System.out.println("SmartLight is " + state + " - Brightness: " + brightness + "%");
    }

    @Override
    public String toString() {
        return String.format("SmartLight[isOn=%b, brightness=%d%%]", isOn, brightness);
    }
}
