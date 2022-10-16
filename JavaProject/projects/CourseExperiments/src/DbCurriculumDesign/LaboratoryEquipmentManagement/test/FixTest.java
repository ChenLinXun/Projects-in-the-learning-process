package DbCurriculumDesign.LaboratoryEquipmentManagement.test;

import DbCurriculumDesign.LaboratoryEquipmentManagement.model.DeviceFix;
import DbCurriculumDesign.LaboratoryEquipmentManagement.model.MultiTableBean2;
import DbCurriculumDesign.LaboratoryEquipmentManagement.server.DeviceFixServer;

import java.util.List;

public class FixTest {

    public static void main(String[] args) {

        //获取一个设备报修服务
        DeviceFixServer deviceFixServer = new DeviceFixServer();

        //使用添加一个报修设备功能
        boolean isInsert = deviceFixServer.fixDeviceInsert(3, "2021.6.24","峰哥牌显微镜",
                "嘎哥修理厂", "500", "莫导");
        System.out.println(isInsert ? "报修成功" : "报修失败");

        //使用根据id查询一个设备报修信息功能
        List<DeviceFix> deviceFixes = deviceFixServer.fixDeviceQueryById(3);
        System.out.println(deviceFixes);


        //使用根据其他信息查询一个设备报修信息功能
        List<MultiTableBean2> multiTableBean2s = deviceFixServer.fixDeviceQueryByOthers("光学仪器", "光学仪器",
                "峰哥牌显微镜", "峰哥牌显微镜", "MQ231", "MQ231", "暂无", "暂无", "暂无", "暂无", "暂无", "暂无",
                "暂无", "暂无", "暂无", "暂无", "暂无", "暂无", 0, 0, "暂无", "暂无");
        System.out.println(multiTableBean2s);

        //使用设备完修反库功能
        boolean isBack = deviceFixServer.fixDeviceBack(3);
        System.out.println(isBack ? "反库成功" : "反库失败");

    }


}
