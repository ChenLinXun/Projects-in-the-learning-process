package DbCurriculumDesign.LaboratoryEquipmentManagement.test;


//假设这里是view层，向server层传入sql语句中的参数（这里不组织sql），来使用服务

import DbCurriculumDesign.LaboratoryEquipmentManagement.model.DeviceStatus;
import DbCurriculumDesign.LaboratoryEquipmentManagement.model.MultiTableBean;
import DbCurriculumDesign.LaboratoryEquipmentManagement.server.DeviceStatusServer;


import java.util.List;

public class StatusTest {

    public static void main(String[] args) {

        //获取设备状态服务
        DeviceStatusServer deviceStatusServer = new DeviceStatusServer();


        //使用根据id查询设备状态服务
        //(也就是说，如果id文本框内有内容，直接使用这个即可)
        List<DeviceStatus> deviceStatuses = deviceStatusServer.queryDeviceStatusById(2);

        System.out.println(deviceStatuses);


        //使用根据id修改设备状态服务
        //(也就是说，如果id文本框内有内容，直接使用这个即可)
        boolean isUpdate = deviceStatusServer.updateDeviceStatusById("正在正常运行", 2);
        System.out.println(isUpdate ? "修改成功！" : "修改失败");


        //使用根据其他信息查看设备状态服务
        //(也就是说，如果id没填，就使用这个)
        //（当使用这个的时候，每个文本框中的内容应该传入两次，如果文本框中的内容为空，则设置传入的内容为"暂无"）
        List<MultiTableBean> multiTableBeans = deviceStatusServer.queryDeviceStatusByOthers("光学仪器", "光学仪器",
                "暂无","暂无","MQ231", "MQ231","暂无", "暂无", "暂无", "暂无", "暂无", "暂无",
                "暂无", "暂无", "暂无", "暂无", "暂无", "暂无",0,0, "暂无", "暂无");


        //使用根据其他信息修改设备状态服务
        //(也就是说，如果id没填，就使用这个)
        deviceStatusServer.updateDeviceStatusByOthers("光学仪器", "光学仪器",
                "暂无","暂无","MQ231", "MQ231","暂无", "暂无", "暂无", "暂无", "暂无", "暂无",
                "暂无", "暂无", "暂无", "暂无", "暂无", "暂无", 0, 0, "暂无", "暂无", "已损坏");



        System.out.println(multiTableBeans);

    }

}
