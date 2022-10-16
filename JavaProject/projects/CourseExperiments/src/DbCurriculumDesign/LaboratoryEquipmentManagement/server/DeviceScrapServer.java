package DbCurriculumDesign.LaboratoryEquipmentManagement.server;

import DbCurriculumDesign.LaboratoryEquipmentManagement.dao.DeviceScrapDao;
import DbCurriculumDesign.LaboratoryEquipmentManagement.model.DeviceFix;
import DbCurriculumDesign.LaboratoryEquipmentManagement.model.DeviceScrap;

import java.util.List;

public class DeviceScrapServer {

    //对一个设备进行报废服务----->插入一个报废设备的方法
    public boolean scrapDeviceInsert(Object... param){

        DeviceScrapDao deviceScrapDao = new DeviceScrapDao();
        boolean isInsert = deviceScrapDao.scrapDeviceInsert(param);

        return isInsert;

    }


    //根据设备id查询报废信息服务----->根据设备id查询报废信息的方法
    public List<DeviceScrap> scrapDeviceQueryById(Object... param){

        String sql = "select * from device_scrap where id = ? ";

        DeviceScrapDao deviceScrapDao = new DeviceScrapDao();
        List<DeviceScrap> deviceScraps = deviceScrapDao.queryMulti(sql,DeviceScrap.class,param);

        return deviceScraps;

    }



    //根据设备信息查询报废信息服务----->根据设备信息查询报废信息的方法
    //****注意！！！****//
    //服务说明：
    // 使用该服务，判断条件的参数要传两遍，也就是30个参数，参数可以是默认值但不能为空！
    public List<DeviceScrap> scrapDeviceQueryByAny(Object... param){

        String sql = "select * from device_scrap where " +
                "(id = ? or ? = '暂无') " +
                "and (type = ? or ? = '暂无') " +
                "and (model = ? or ? = '暂无') " +
                "and (scrap_date = ? or ? = '暂无') "+
                "and (date = ? or ? = '暂无') ";

        DeviceScrapDao deviceScrapDao = new DeviceScrapDao();
        List<DeviceScrap> deviceScraps = deviceScrapDao.scrapDeviceQueryByAny(sql, param);

        return deviceScraps;

    }


    //根据报废年月日查询报废情况
    public List<DeviceScrap> scrapDeviceQueryByYearMonthDay(Object... param){


        DeviceScrapDao deviceScrapDao = new DeviceScrapDao();


        //输入年
        if("".equals(param[1])&&"".equals(param[2])) {

            String sql1 = "select * from device_scrap where " +
                    "(scrap_date like concat( ?,'.' , '%' , '.' , '%') or ? = '暂无')";

            List<DeviceScrap> deviceScraps = deviceScrapDao.queryMulti(sql1, DeviceScrap.class,
                    param[0], param[3]);

            return deviceScraps;


        }else if("".equals(param[0])&&"".equals(param[2])) {//输入月

            String sql1 = "select * from device_scrap where " +
                    "(scrap_date like concat('%','.' , ? , '.' , '%') or ? = '暂无')";

            List<DeviceScrap> deviceScraps = deviceScrapDao.queryMulti(sql1, DeviceScrap.class,
                    param[1], param[3]);

            return deviceScraps;


        }else if("".equals(param[0])&&"".equals(param[1])){//输入日

            String sql1 = "select * from device_scrap where " +
                    "(scrap_date like concat( '%','.' , '%' , '.' , ?) or ? = '暂无')";

            List<DeviceScrap> deviceScraps = deviceScrapDao.queryMulti(sql1, DeviceScrap.class,
                    param[2], param[3]);

            return deviceScraps;


        }else if(!("".equals(param[0]))&&!("".equals(param[1]))&&"".equals(param[2])){//输入年份月份

            String sql1 = "select * from device_scrap where " +
                    "(scrap_date like concat( ?,'.' , ? , '.' , '%') or ? = '暂无')";

            List<DeviceScrap> deviceScraps = deviceScrapDao.queryMulti(sql1, DeviceScrap.class,
                    param[0],param[1], param[3]);

            return deviceScraps;


        }else if(!("".equals(param[0]))&&!("".equals(param[2]))&&"".equals(param[1])){//输入年份日

            String sql1 = "select * from device_scrap where " +
                    "(scrap_date like concat( ?,'.' , '%' , '.' , ?) or ? = '暂无')";

            List<DeviceScrap> deviceScraps = deviceScrapDao.queryMulti(sql1, DeviceScrap.class,
                    param[0],param[2], param[3]);

            return deviceScraps;


        }else {//输入月份日

            String sql1 = "select * from device_scrap where " +
                    "(scrap_date like concat( '%','.' , ? , '.' , ?) or ? = '暂无')";

            List<DeviceScrap> deviceScraps = deviceScrapDao.queryMulti(sql1, DeviceScrap.class,
                    param[1], param[2],param[3]);

            return deviceScraps;

        }


    }


}
