public class DeviceAction {
    private String command;
    private String parameters;
    private String description;
    private Device device;

    public DeviceAction(String command, String parameters, Device device) {
        this.command = command;
        this.parameters = parameters;
        //    this.description = description;
        this.device = device;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public void execute() {
        // 检验设备是否在线
        if (device == null || !device.isOnline()) {
            System.out.println("设备不存在或者离线，无法进行相对应的操作");
            return;
        }

        // 根据指令类型分发执行逻辑
        switch (command) {
            case "powerOn":
                device.powerOn();
                break;
            case "powerOff":
                device.powerOff();
                break;
            case "setTemperature":
                if (device instanceof AirConditioner ac) {
                    try {
                        double temp = Double.parseDouble(parameters);
                        ac.setTargetTemp(temp);
                    } catch (NumberFormatException e) {
                        System.out.println("温度格式错误：" + parameters);
                    }
                } else {
                    System.out.println("该设备不支持调节温度操作");

                }
                break;
            case "setBrightness":
                if (device instanceof LightBulb) {
                    LightBulb bulb = (LightBulb) device;
                    try {
                        int brightness = Integer.parseInt(parameters);
                        bulb.setBrightness(brightness);
                    } catch (NumberFormatException e) {
                        System.out.println("亮度参数格式错误：" + parameters);
                    }
                } else {
                    System.out.println("该设备不支持调节亮度操作");
                }

                break;
            case "lock":
                if (device instanceof SmartLock lock) {
                    lock.setLocked(true);
                } else {
                    System.out.println("该设备不支持锁定操作");
                }
                break;
            case "unlock":
                if (device instanceof SmartLock lock) {
                    lock.setLocked(false);
                } else {
                    System.out.println("该设备不支持锁定操作");
                }
                break;
            default:
                System.out.println("不支持命令：" + command);
        }


    }
}
