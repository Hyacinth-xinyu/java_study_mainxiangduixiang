import java.util.ArrayList;
import java.util.List;

public class Manufacturer {
    private String manufacturerId;
    private String name;
    private String location;
    private List<Vessel> vessels = new ArrayList<>();

    public Manufacturer(String manufacturerId, String name, String location){
        this.manufacturerId = manufacturerId;
        this.name = name;
        this.location = location;
    }

    //getter

    public String getManufacturerId() {
        return manufacturerId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public List<Vessel> displayVessels(){
        return vessels;
    }

    // setter
    public void setManufacturerId(String manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void addVessel(Vessel vessel){
        vessels.add(vessel);
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "manufacturerId='" + manufacturerId + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", vessels=" + vessels +
                '}';
    }
}
