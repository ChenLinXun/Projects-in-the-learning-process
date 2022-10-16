package DbCurriculumDesign.LaboratoryEquipmentManagement.test;

import DbCurriculumDesign.LaboratoryEquipmentManagement.model.LibraryDevice;
import DbCurriculumDesign.LaboratoryEquipmentManagement.server.LibDeviceServer;


import java.util.List;

//假设这里是view层，向server层传入sql语句中的参数（这里不组织sql），来使用服务

public class DeviceTest {

    public static void main(String[] args) {

        //获取库存服务
        LibDeviceServer lDServer = new LibDeviceServer();

        //使用设备入库服务
        boolean isInsert1 = lDServer.deviceInsert(5, "光学仪器", "峰哥牌显微镜",
                "MQ231", "5#", "90", "200", "2021.6.22", "峰哥物理仪器有限公司", "Kitty", 2, "第一实验室");
        System.out.println("============================");
        System.out.println(isInsert1 ? "入库成功！" : "入库失败！");

        //再次使用入库服务
        boolean isInsert2 = lDServer.deviceInsert(6, "光学仪器", "峰哥牌显微镜",
                "MQ231", "7#", "90", "200", "2021.6.23", "峰哥物理仪器有限公司", "Kitty", 0, "第一实验室");
        System.out.println("============================");
        System.out.println(isInsert2 ? "入库成功！" : "入库失败！");

        //使用库存查看服务
        List<LibraryDevice> resultList = lDServer.deviceAllQuery();
        System.out.println(resultList);

    }



}
