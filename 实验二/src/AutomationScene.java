import java.util.ArrayList;
import java.util.List;

public class AutomationScene {
    private int sceneId;
    private String name;
    private String description;
    private List<DeviceAction> deviceActions = new ArrayList<>();

    public AutomationScene(int sceneId, String name, String description) {
        this.sceneId = sceneId;
        this.name = name;
        this.description = description;
    }

    public void addAction(DeviceAction action) {
        deviceActions.add(action);
    }

    public void removeAction(DeviceAction action) {
        deviceActions.remove(action);
    }

    public List<DeviceAction> getActions() {
        return deviceActions;
    }

    public void setDeviceActions(List<DeviceAction> deviceActions) {
        this.deviceActions = deviceActions;
    }


    public int getSceneld() {
        return sceneId;
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void manualTrig() {
        System.out.println("手动触发场景：" + this.name + "(ID: " + this.sceneId + ")");
        for (DeviceAction action : deviceActions) {
            action.execute();
        }
    }

}
