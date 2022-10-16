package DbCurriculumDesign.LaboratoryEquipmentManagement.test;

import DbCurriculumDesign.LaboratoryEquipmentManagement.model.DeviceScrap;
import DbCurriculumDesign.LaboratoryEquipmentManagement.server.DeviceScrapServer;

import java.util.List;

public class ScrapTest {

    public static void main(String[] args) {

        //获取一个报废设备服务
        DeviceScrapServer deviceScrapServer = new DeviceScrapServer();

        //使用报废一个设备服务
        boolean isInsert = deviceScrapServer.scrapDeviceInsert(4, "2021", "6.28", "第二季度");
        System.out.println(isInsert ? "报废成功" : "报废失败");

        //使用查询设备报废信息服务
        List<DeviceScrap> deviceScraps = deviceScrapServer.scrapDeviceQueryByAny(0, 0, "暂无", "暂无",
                "暂无", "暂无", "MQ231", "MQ231", "暂无", "暂无", "暂无", "暂无", "暂无", "暂无",
                "暂无", "暂无", "暂无", "暂无", "暂无", "暂无", 0, 0, "暂无", "暂无", "暂无",
                "暂无", "6", "6", "暂无", "暂无");
        System.out.println(deviceScraps);



    }

}
