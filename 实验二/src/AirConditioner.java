import java.util.Date;

public class AirConditioner extends Device implements EnergyReporting {
    private double currTemp;
    private double targetTemp;


    public AirConditioner(int deviceId, String name, Manufacturer manufacturer) {
        super(deviceId, name, manufacturer);

    }

    public double getCurrTemp() {
        return currTemp;
    }

    public void setCurrTemp(double currTemp) {
        this.currTemp = currTemp;
    }

    public double getTargetTemp() {
        return targetTemp;
    }

    public void setTargetTemp(double targetTemp) {

        this.targetTemp = targetTemp;
    }

    @Override
    public double getPower() {
        return 1.5;
    }

    @Override
    public double getReport(Date startTime, Date endTime) {
        long duration = endTime.getTime() - startTime.getTime();
        double hours = duration / (100.0 * 60 * 60);
        double power = 1.5;
        return power * hours;
    }


}
