import java.util.Date;

public class LightBulb extends Device implements EnergyReporting {
    private int brightness;
    private int colorTemp;

    public LightBulb(int deviceId, String name, Manufacturer manufacturer) {
        super(deviceId, name, manufacturer);
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public int getColorTemp() {
        return colorTemp;
    }

    public void setColorTemp(int colorTemp) {
        this.colorTemp = colorTemp;
    }

    @Override
    public double getPower() {
        return 1.5;
    }

    @Override
    public double getReport(Date stratTime, Date endTime) {
        long duration = endTime.getTime() - stratTime.getTime();
        double hours = duration / (100.0 * 60 * 60);
        double power = 0.01;
        return power * hours;
    }
}
