import java.util.Date;

public class SmartLock extends Device {
    private boolean isLocked;
    private int batteryLevel;


    public SmartLock(int deviceId, String name, Manufacturer manufacturer) {
        super(deviceId, name, manufacturer);
        this.isLocked = false;
        this.batteryLevel = 0;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public void setLocked(boolean b) {
        this.isLocked = b;
    }

    @Override
    public double getReport(Date startTime, Date endTime) {
        return 0;
    }


}
