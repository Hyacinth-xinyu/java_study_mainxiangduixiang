import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Room {
    private int roomId;
    private String name;
    private double area;
    private List<Device> devices = new ArrayList<>();

    public Room(int roomId, String name, double area) {
        this.roomId = roomId;
        this.name = name;
        this.area = area;
    }


    public int getRoomId() {
        return roomId;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void addDevice(Device device) {
        devices.add(device);
    }

    public void removeDevice(int deviceId) {
        Iterator<Device> iterator = devices.iterator();
        while (iterator.hasNext()) {
            Device device = iterator.next();
            if (device.getDeviceId() == deviceId) {
                iterator.remove();
                break;
            }
        }
    }

    public List<Device> getDevices() {
        return devices;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomId == room.roomId;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", name='" + name + '\'' +
                ", area=" + area +
                '}';
    }


}
