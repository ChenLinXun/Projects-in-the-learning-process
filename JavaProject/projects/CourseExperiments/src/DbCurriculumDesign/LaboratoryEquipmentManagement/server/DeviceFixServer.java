package DbCurriculumDesign.LaboratoryEquipmentManagement.server;


import DbCurriculumDesign.LaboratoryEquipmentManagement.dao.DeviceFixDao;
import DbCurriculumDesign.LaboratoryEquipmentManagement.dao.MultiTable2Dao;
import DbCurriculumDesign.LaboratoryEquipmentManagement.model.DeviceFix;
import DbCurriculumDesign.LaboratoryEquipmentManagement.model.MultiTableBean;
import DbCurriculumDesign.LaboratoryEquipmentManagement.model.MultiTableBean2;

import java.util.List;

public class DeviceFixServer {


    //对一个设备进行报修服务----->插入一个报修设备的方法
    public boolean fixDeviceInsert(Object... param){

        String sql = "Insert into device_fix values(?,?,?,?,?)";

        //(这个服务对device_fix单表操作，所以使用DeviceFixDao)
        DeviceFixDao deviceFixDao = new DeviceFixDao();

        boolean isInsert = deviceFixDao.fixDeviceInsert(sql, param);

        return isInsert;

    }


    //根据设备的id查询设备报修信息服务----->根据id查询设备报修信息的方法
    public List<DeviceFix> fixDeviceQueryById(Object... param){

        String sql = "select * from device_fix where id = ?";

        //(这个服务对device_fix单表操作，所以使用DeviceFixDao)
        DeviceFixDao deviceFixDao = new DeviceFixDao();

        List<DeviceFix> deviceFixes = deviceFixDao.fixDeviceQueryById(sql, param);

        return deviceFixes;

    }


    //根据设备的其他报修信息查询设备报修信息服务----->根据设备的其他报修信息查询设备报修信息的方法
    public List<DeviceFix> fixDeviceQuery(Object... param){

        String sql = "select * from device_fix where " +
                "(id = ? or ? = '暂无') "+
                "and (fix_factory = ? or ? = '暂无') " +
                "and (fix_date = ? or ? = '暂无') ";

        //(这个服务对device_fix单表操作，所以使用DeviceFixDao)
        DeviceFixDao deviceFixDao = new DeviceFixDao();

        List<DeviceFix> deviceFixes = deviceFixDao.fixDeviceQueryById(sql, param);

        return deviceFixes;

    }


    //根据设备的其他信息查询设备报修信息服务----->根据其他信息查询设备报修信息的方法
    //****注意！！！****//
    //服务说明：
    // 使用该服务，判断条件的参数要传两遍，也就是22个参数，参数可以是默认值但不能为空！
    public List<MultiTableBean2> fixDeviceQueryByOthers(Object... param){


        //(这个服务对device_library表和device_fix表联合查询，所以使用MultiTable2Dao)
        MultiTable2Dao multiTable2Dao = new MultiTable2Dao();

        String sql = "select device_fix.* from device_fix,device_library where " +
                "device_fix.id = device_library.id " +
                "and (type = ? or ? = '暂无') " +
                "and (device_library.name = ? or ? = '暂无') " +
                "and (model = ? or ? = '暂无' ) " +
                "and (spec = ? or ? = '暂无') " +
                "and (money = ? or ? = '暂无') " +
                "and (num = ? or ? = '暂无') " +
                "and (date = ? or ? = '暂无') " +
                "and (factory = ? or ? = '暂无') " +
                "and (buyer = ? or ? = '暂无') " +
                "and (batch = ? or ? = 0) " +
                "and (crname = ? or ? = '暂无') ";

        List<MultiTableBean2> multiTableBean2s = multiTable2Dao.fixDeviceQueryByOthers(sql, param);

        return multiTableBean2s;

    }

    //根据设备报修年月日查看设备报修情况服务------->根据设备报修年月日查看设备报修情况的方法
    //****注意！！！****//
    //服务说明：
    // 使用该服务，判断条件的参数要传两遍，也就是24个参数，参数可以是默认值但不能为空！
    public List<DeviceFix> queryDeviceFixByYearMonthDay(Object... param){


        //(这个服务对device_library表和device_status表联合查询，所以使用MultiTableDao)
        DeviceFixDao deviceFixDao = new DeviceFixDao();

        //输入年
        if("".equals(param[3])&&"".equals(param[4])) {

            String sql1 = "select * from device_fix where " +
                    "(fix_factory = ? or ? = '暂无' ) " +
                    "and (fix_date like concat( ?,'.' , '%' , '.' , '%') or ? = '暂无')";

            List<DeviceFix> deviceFixes = deviceFixDao.queryMulti(sql1, DeviceFix.class,
                    param[0], param[1], param[2], param[5]);

            return deviceFixes;


        }else if("".equals(param[2])&&"".equals(param[4])) {//输入月

            String sql1 = "select * from device_fix where " +
                    "(fix_factory = ? or ? = '暂无' ) " +
                    "and (fix_date like concat('%','.' , ? , '.' , '%') or ? = '暂无')";

            List<DeviceFix> deviceFixes = deviceFixDao.queryMulti(sql1, DeviceFix.class,
                    param[0], param[1], param[3], param[5]);

            return deviceFixes;


        }else if("".equals(param[2])&&"".equals(param[3])){//输入日

            String sql1 = "select * from device_fix where " +
                    "(fix_factory = ? or ? = '暂无' ) " +
                    "and (fix_date like concat( '%','.' , '%' , '.' , ?) or ? = '暂无')";

            List<DeviceFix> deviceFixes = deviceFixDao.queryMulti(sql1, DeviceFix.class,
                    param[0], param[1], param[4], param[5]);

            return deviceFixes;


        }else if(!("".equals(param[2]))&&!("".equals(param[3]))&&"".equals(param[4])){//输入年份月份

            String sql1 = "select * from device_fix where " +
                    "(fix_factory = ? or ? = '暂无' ) " +
                    "and (fix_date like concat( ?,'.' , ? , '.' , '%') or ? = '暂无')";

            List<DeviceFix> deviceFixes = deviceFixDao.queryMulti(sql1, DeviceFix.class,
                    param[0], param[1], param[2],param[3], param[5]);

            return deviceFixes;


        }else if(!("".equals(param[2]))&&!("".equals(param[4]))&&"".equals(param[3])){//输入年份日

            String sql1 = "select * from device_fix where " +
                    "(fix_factory = ? or ? = '暂无' ) " +
                    "and (fix_date like concat( ?,'.' , '%' , '.' , ?) or ? = '暂无')";

            List<DeviceFix> deviceFixes = deviceFixDao.queryMulti(sql1, DeviceFix.class,
                    param[0], param[1], param[2], param[4],param[5]);

            return deviceFixes;


        }else {//输入月份日

            String sql1 = "select * from device_fix where " +
                    "(fix_factory = ? or ? = '暂无' ) " +
                    "and (fix_date like concat( '%','.' , ? , '.' , ?) or ? = '暂无')";

            List<DeviceFix> deviceFixes = deviceFixDao.queryMulti(sql1, DeviceFix.class,
                    param[0], param[1], param[3], param[4],param[5]);

            return deviceFixes;

        }

    }


    //根据已修好的设备id，将这个设备返回实验室使用的服务
    public boolean fixDeviceBack( Object... param){

        //这个服务分别对报修表和运行表进行操作，这两个操作的语句在dao里完成

        DeviceFixDao deviceFixDao = new DeviceFixDao();

        boolean isBack = deviceFixDao.fixDeviceBack(param);

        return isBack;

    }



}
