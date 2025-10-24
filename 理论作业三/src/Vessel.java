import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vessel {
    private String id;
    private String specificModel;
    private String launchDate;
    private double maxSpeed;
    private List<Manufacturer> manufacturers = new ArrayList<>();
    private List<CrewMember> crewMembers = new ArrayList<>();

    public Vessel(String id,String specificModel,double maxSpeed,String launchDate) {
        this.id = id;
        this.specificModel = specificModel;
        this.launchDate = launchDate;
        this.maxSpeed = maxSpeed;

    }

    // get方法

    public String getId() {
        return id;
    }

    public String getSpecificModel() {
        return specificModel;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public List<Manufacturer> displayManufacturers() {
        return manufacturers;
    }

    public List<CrewMember> displayCrewMembers() {
        return crewMembers;
    }

    //setter

    public void setId(String id) {
        this.id = id;
    }

    public void setSpecificModel(String specificModel) {
        this.specificModel = specificModel;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void addManufacturer(Manufacturer manufacturer){
        manufacturers.add(manufacturer);
    }

    public void addCrewMember(CrewMember crewMember){
        crewMembers.add(crewMember);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vessel vessel = (Vessel) o;
        return Objects.equals(id, vessel.id);
    }

    @Override
    public String toString() {
        return "Vessel{" +
                "id='" + id + '\'' +
                ", specificModel='" + specificModel + '\'' +
                ", launchDate='" + launchDate + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", manufacturers=" + manufacturers +
                ", crewMembers=" + crewMembers +
                '}';
    }
}
