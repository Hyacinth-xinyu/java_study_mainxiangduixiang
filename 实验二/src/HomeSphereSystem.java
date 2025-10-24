import java.util.Date;
import java.util.List;

public class HomeSphereSystem {
    private final Household household;
    private User currentUser;

    public HomeSphereSystem(Household household) {
        this.household = household;
    }


    public User getCurrentUser() {
        return currentUser;
    }

    //login方法
    public User login(String loginName, String loginPassword) {
        if (household == null) {
            System.out.println("家庭不存在!!!");
            return null;
        } else {
            if (household.findUSer(loginName, loginPassword) == null) {
                System.out.println("登录失败，请重新登录");
                return null;
            } else {
                User user = household.findUSer(loginName, loginPassword);
                this.currentUser = user;
                return user;
            }

        }
    }

    public void logoff() {
        this.currentUser = null;
        System.out.println("已经退出登录");

    }

    public User register(String loginName, String loginPassword, String userName, String email) {
        // 验证参数（非空去空格）
        loginName = loginName != null ? loginName.trim() : "";
        loginPassword = loginPassword != null ? loginPassword.trim() : "";
        userName = userName != null ? userName.trim() : "";
        email = email != null ? email.trim() : "";

        if (loginName.isEmpty() || loginPassword.isEmpty() || userName.isEmpty() || email.isEmpty()) {
            System.out.println("注册失败：参数不能为空！！！");
            return null;
        }

        // 验证用户是否存在
        if (household.findUserByLoginName(loginName) != null) {
            System.out.println("注册失败：用户名已经被占用,请重新注册");
            return null;
        }

        // 生成用户Id并创建User示例
        int userId = household.getUsers().size() + 1;
        User newUser = new User(
                userId,
                loginName,
                loginPassword,
                userName,
                email
        );
        household.addUser(newUser);

        System.out.printf("注册成功：您的账号是 %s", loginName);

        return newUser;

    }

    public void displayUsers() {
        if (household == null) {
            System.out.println("未找到家庭信息");
            return;
        }
        List<User> userList = household.getUsers();
        if (userList == null || userList.isEmpty()) {
            System.out.println("当前家庭中没有用户!!!");
            return;
        }

        System.out.println("======================家庭用户形象列表=======================");
        for (User user : userList) {
            System.out.println(user.toString());
        }

    }

    public void displayRooms() {
        if (household == null) {
            System.out.println("未找到家庭信息");
            return;
        }
        List<Room> roomList = household.getRooms();
        if (roomList == null || roomList.isEmpty()) {
            System.out.println("当前家庭中没有用户!!!");
            return;
        }

        System.out.println("====================家庭房间列表==================");
        for (Room room : roomList) {
            System.out.println(room.toString());
        }

    }

    public void displayDevices() {
        if (household == null) {
            System.out.println("未找到家庭信息");
            return;
        }

        List<Room> roomList = household.getRooms();
        if (roomList == null || roomList.isEmpty()) {
            System.out.println("当前家庭中没有用户!!!");
            return;
        }

        System.out.println("======================家庭设备列表==================");
        for (Room room : roomList) {
            List<Device> deviceList = room.getDevices();
            if (deviceList == null || deviceList.isEmpty()) {
                System.out.println("房间" + room.getName() + "中没有设备");
                continue;
            }

            System.out.println("-------房间:" + room.getName() + "-------");
            for (Device device : deviceList) {
                System.out.println(device.toString());
            }
        }

    }

    public void displayAutoScenes() {
        if (household == null) {
            System.out.println("未找到家庭信息");
            return;
        }
        List<AutomationScene> automationSceneList = household.getAutoScenes();
        if (automationSceneList == null || automationSceneList.isEmpty()) {
            System.out.println("当前家庭中没有用户!!!");
            return;
        }

        System.out.println("===================家庭自动场景列表=====================");
        for (AutomationScene automationScene : automationSceneList) {
            System.out.println(automationScene.toString());
        }

    }

    public void displayEnergyReportings(Date stratTime, Date endTime) {
        if (household == null) {
            System.out.println("未找到家庭信息");
            return;
        }

        List<Room> roomList = household.getRooms();
        if (roomList == null || roomList.isEmpty()) {
            System.out.println("当前家庭中没有房间,无法计算耗能");
            return;
        }

        double totalEnergy = 0.0;
        System.out.println("=============能耗报告(" + stratTime + "至" + endTime + ")" + "==========");
        for (Room room : roomList) {
            List<Device> deviceList = room.getDevices();
            if (deviceList == null || deviceList.isEmpty()) {
                System.out.println("房间" + room.getName() + "中无设备,无法计算能耗");
                continue;
            }

            System.out.println("-------房间:" + room.getName() + "---------");
            for (Device device : deviceList) {
                if (device instanceof EnergyReporting) {
                    EnergyReporting energyEnergy = (EnergyReporting) device;
                    double deviceEnergy = energyEnergy.getReport(stratTime, endTime);
                    totalEnergy += deviceEnergy;
                    System.out.println("设备" + device.getName() + ",能耗:" + deviceEnergy + "度");
                } else {
                    System.out.println("设备" + device.getName() + ",不支持能耗统计");
                }

            }
        }
        System.out.println("==================总能耗:" + totalEnergy + "度===============");
    }


    public void manulTrigSceneById(int sceneId) {
        if (household == null) {
            System.out.println("未找到家庭信息");
            return;
        }

        AutomationScene targetScene = null;
        List<AutomationScene> sceneList = household.getAutoScenes();
        if (sceneList != null) {
            for (AutomationScene automationScene : sceneList) {
                if (automationScene.getSceneld() == sceneId) {
                    targetScene = automationScene;
                    break;
                }
            }
        }

        if (targetScene == null) {
            System.out.println("未找到ID为" + sceneId + ",的自动化场景");
            return;
        }

        System.out.println("正在触发场景:" + targetScene.getName() + "(" + targetScene.getDescription() + ")");
        List<DeviceAction> actionList = targetScene.getActions();
        if (actionList != null && !actionList.isEmpty()) {
            for (DeviceAction deviceAction : actionList) {
                deviceAction.execute();
                System.out.println("执行设备动作:" + deviceAction.getCommand() + "(参数:" + deviceAction.getParameters() + ")");

            }
        } else {
            System.out.println("该场景没有设备可执行");
        }
    }


    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
