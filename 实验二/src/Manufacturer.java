import java.util.ArrayList;
import java.util.List;

public class Manufacturer {
    private int manufacturerId;
    private String name;
    private String protocols;
    private List<Device> devices = new ArrayList<>();


    public Manufacturer(int manufacturerId, String name, String protocols) {
        this.manufacturerId = manufacturerId;
        this.name = name;
        this.protocols = protocols;

    }

    public int getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProtocols() {
        return protocols;
    }

    public void setProtocols(String protocols) {
        this.protocols = protocols;
    }


    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public void addDevice(Device device) {
        devices.add(device);
    }

    public void removeDevice(Device device) {
        devices.remove(device);
    }
}
