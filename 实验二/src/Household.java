import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Household {
    private String address;
    private int householdId;
    private List<Room> rooms = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<AutomationScene> automationScenes = new ArrayList<>();
    private User admin;


    public Household(int householdID, String address) {
        this.householdId = householdID;
        this.address = address;

    }


    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void removeRoom(int roomId) {
        Iterator<Room> iterator = rooms.iterator();
        while (iterator.hasNext()) {
            Room room = iterator.next();
            if (room.getRoomId() == roomId) {
                iterator.remove();
                break;
            }
        }

    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(int userId) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getUserId() == userId) {
                iterator.remove();
                break;
            }
        }

    }

    public void addAutoScene(AutomationScene automationScene) {
        automationScenes.add(automationScene);
    }

    public void removeAutoScene(int aceneId) {
        Iterator<AutomationScene> iterator = automationScenes.iterator();
        while (iterator.hasNext()) {
            AutomationScene automationScene = iterator.next();
            if (automationScene.getSceneld() == aceneId) {
                iterator.remove();
                break;
            }
        }

    }

    public List<AutomationScene> getAutoScenes() {
        return automationScenes;
    }

    public List<Room> getRooms() {
        return rooms;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(int householdId) {
        this.householdId = householdId;
    }


    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;

    }

    public void setAutomationScenes(List<AutomationScene> automationScenes) {
        this.automationScenes = automationScenes;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
        admin.setAdmin(true);
    }

    public List<Device> listAllDevices() {
        List<Device> allDeivces = new ArrayList<>();
        for (Room room : rooms) {
            allDeivces.addAll(room.getDevices());
        }
        return allDeivces;
    }

    public User findUserByLoginName(String loginName) {
        for (User user : users) {
            if (user.getUserName().equals(loginName)) {
                return user;
            }
        }
        return null;
    }

    public User findUSer(String loginName, String loginPassword) {
        for (User user : users) {
            if (user.getPassword().equals(loginPassword) && user.getLoginName().equals(loginName)) {
                return user;
            }
        }
        return null;
    }


}
