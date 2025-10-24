import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShipInformationManagementSystem {
    private List<Vessel> vessels = new ArrayList<>();
    private List<CrewMember> crewMembers = new ArrayList<>();
    private List<Manufacturer> manufacturers = new ArrayList<>();

    public void demoAddVessel(Vessel vessel){
        if(vessel == null){
            throw new IllegalArgumentException("该参数不能为null");
        }
        else {
            vessels.add(vessel);
            System.out.println("船只id为" + vessel.getId() + "已被添加到系统中");
            return;
        }

    }

    public void addManufacturer(Manufacturer manufacturer){
        // 判断是非为null
        if(manufacturer == null){
            throw new IllegalArgumentException("该参数不能为null");
        }
        else  {
            manufacturers.add(manufacturer);
            System.out.println("制造商：" + manufacturer.getName() + "已经被添加进入系统了");
            return;
        }

    }

    public void demoAddCrewToVessel(String vesselId,CrewMember crewMember){
        //检查船员是非为空
        if(crewMember == null){
            throw new IllegalArgumentException("船员参数不能为空");
        }
        else {
            //通过VesselId找到对应船只
            for(Vessel vessel : vessels){
                if(vessel.getId().equals(vesselId)){
                    vessel.addCrewMember(crewMember);
                    break;
                }
            }
        }
        return;
    }

    public Vessel findVesselByVesselId(String vesselId){
        for(Vessel vessel:vessels){
            if(vessel.getId().equals(vesselId)){
                return vessel;
            }
        }
        return null;
    }

    public void demoPrintVesselInfo(String vesselId){
        // 找到对应船只应该打印相关信息
        for(Vessel vessel : vessels){
            if(vessel.getId().equals(vesselId)){
                vessel.toString();
                return;
            }
        }
        throw new ShipNotFoundException("船只Id为" + vesselId + "的船只未被找到" );
    }

    public void demoPrintManufacturers(String vesselId){
        for(Vessel vessel : vessels){
            if(vessel.getId().equals(vesselId)){
                List<Manufacturer> manufacturerList  = vessel.displayManufacturers();
                for (Manufacturer manufacturer : manufacturerList) {
                    String string = manufacturer.toString();
                    System.out.println(string);
                }
                return;
            }
        }
        throw new ShipNotFoundException("船只Id为" + vesselId + "的船只未被找到" );
    }

    public void demoRemoveVessel(String vesselId){
        for(Vessel vessel : vessels){
            if(vessel.getId().equals(vesselId)){
                vessels.remove(vessel);
                return;
            }
        }
        throw new ShipNotFoundException("船只Id为" + vesselId + "的船只未被找到" );
    }

}
