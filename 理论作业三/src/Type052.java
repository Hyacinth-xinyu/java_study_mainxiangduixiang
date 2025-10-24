public class Type052 extends Vessel{
    private int missileQuantity;

    public Type052(String id,String specificModel,double maxSpeed,String launchDate,int missileQuantity){
        super(id, specificModel, maxSpeed,launchDate);
        this.missileQuantity = missileQuantity;
    }

    public int getMissileQuantity() {
        return missileQuantity;
    }

    public void setMissileQuantity(int missileQuantity) {
        this.missileQuantity = missileQuantity;
    }
}
