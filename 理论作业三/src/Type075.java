public class Type075 extends Vessel{
    private int maxCrewCapacity;

    public Type075(String id,String specificModel,double maxSpeed,String launchDate,int maxCrewCapacity){
        super(id, specificModel, maxSpeed, launchDate);
        this.maxCrewCapacity = maxCrewCapacity;
    }

    public int getMaxCrewCapacity() {
        return maxCrewCapacity;
    }

    public void setMaxCrewCapacity(int maxCrewCapacity) {
        this.maxCrewCapacity = maxCrewCapacity;
    }
}
