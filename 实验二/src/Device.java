import java.util.Date;
import java.util.List;

public abstract class Device {
    private int deviceId;
    private String name;
    private boolean isOnline;
    private boolean powerStatus;
    private List<RunningLog> runningLogs;
    private Manufacturer manufacturer;

    // 构造函数
    public Device(int deviceId, String name, Manufacturer manufacturer) {
        this.deviceId = deviceId;
        this.name = name;
        this.manufacturer = manufacturer;
        this.isOnline = true;
        this.powerStatus = true;
    }

    // getter
    public int getDeviceId() {
        return deviceId;
    }

    public String getName() {
        return name;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public boolean isPowerStatus() {
        return powerStatus;
    }

    // powerOn方法
    public void powerOn() {
        this.isOnline = true;
        this.powerStatus = true;

    }

    // powerOff方法
    public void powerOff() {
        this.isOnline = false;
        this.powerStatus = false;

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return deviceId == device.deviceId;
    }

    @Override
    public String toString() {
        return "Device{" +
                "deviceId=" + deviceId +
                ", name='" + name + '\'' +
                ", isOnline=" + isOnline +
                ", powerStatus=" + powerStatus +
                '}';
    }


    public abstract double getReport(Date startTime, Date endTime);
}
