// 程序入口：只负责“创建对象 + 调用演示方法”，不写 try/catch
public class Main {                                            // Main 类
    public static void main(String[] args) {                   // 主函数入口
        ShipInformationManagementSystem sims = new ShipInformationManagementSystem(); // 创建系统对象

        Manufacturer hudong  = new Manufacturer("M001", "Hudong-Zhonghua", "Shanghai"); // 制造商1
        Manufacturer jiangnan= new Manufacturer("M002", "Jiangnan Shipyard", "Shanghai"); // 制造商2
        sims.addManufacturer(hudong);                          // 加入系统
        sims.addManufacturer(jiangnan);                        // 加入系统

        Type052 destroyer = new Type052("052D-001", "052D", 30.0, "2021-06-01", 64); // 052 舰
        Type075 assault   = new Type075("075-101", "075", 28.0, "2022-01-10", 2);    // 075 舰（容量 2）

        destroyer.addManufacturer(hudong);                     // 052 舰由沪东制造
        destroyer.addManufacturer(jiangnan);                   // 052 舰由江南协作
        assault.addManufacturer(jiangnan);                     // 075 舰由江南制造

        CrewMember c1 = new CrewMember("C001", "Li Wei", "Captain", "13800000001"); // 船员1
        CrewMember c2 = new CrewMember("C002", "Zhang Qiang", "Officer", "13800000002"); // 船员2
        CrewMember c3 = new CrewMember("C003", "Wang Hao", "Technician", "13800000003"); // 船员3

        sims.demoAddVessel(destroyer);                         // 演示：添加有效舰船（成功）
        sims.demoAddVessel(assault);                           // 演示：添加有效舰船（成功）
        sims.demoAddVessel(null);                              // 演示：添加 null（触发 IllegalArgumentException）

        sims.demoAddCrewToVessel("052D-001", c1);              // 演示：给 052 舰加船员1（成功）
        sims.demoAddCrewToVessel("052D-001", c2);              // 演示：给 052 舰加船员2（成功）
        sims.demoAddCrewToVessel("075-101", c3);               // 演示：给 075 舰加船员（成功，此时 075 舰已有 1 人）

        sims.demoPrintVesselInfo("052D-001");                  // 演示：打印 052 舰信息（成功）
        sims.demoPrintVesselInfo("999");                       // 演示：打印不存在舰船（触发自定义异常）

        sims.demoPrintManufacturers("052D-001");               // 演示：打印 052 舰制造商列表（成功）
        sims.demoRemoveVessel("999");                          // 演示：删除不存在舰船（触发自定义异常）
    }                                                          // main 结束
}
