import java.util.Date;

public class BathroomScale extends Device {
    private double bodyMass;
    private int batteryLevel;

    public BathroomScale(int deviceId, String name, Manufacturer manufacturer) {
        super(deviceId, name, manufacturer);
    }

    public double getBodyMass() {
        return bodyMass;
    }

    public void setBodyMass(double bodyMass) {
        this.bodyMass = bodyMass;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    @Override
    public double getReport(Date startTime, Date endTime) {
        return 0;
    }
}
