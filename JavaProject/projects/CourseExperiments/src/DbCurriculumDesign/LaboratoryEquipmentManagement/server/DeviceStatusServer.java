package DbCurriculumDesign.LaboratoryEquipmentManagement.server;

import DbCurriculumDesign.LaboratoryEquipmentManagement.dao.DeviceStatusDao;
import DbCurriculumDesign.LaboratoryEquipmentManagement.dao.MultiTableDao;
import DbCurriculumDesign.LaboratoryEquipmentManagement.model.DeviceStatus;
import DbCurriculumDesign.LaboratoryEquipmentManagement.model.MultiTableBean;
import DbCurriculumDesign.LaboratoryEquipmentManagement.util.DbUtil;

import java.sql.Connection;
import java.util.List;

public class DeviceStatusServer {


    //建立设备运行状态信息的服务----->插入一个设备运行状态的方法
    public boolean insertDeviceStatus(Object... param){

        DeviceStatusDao deviceStatusDao = new DeviceStatusDao();

        String sql = "insert into device_status values(?,?,?,?)";

        boolean isInsert = deviceStatusDao.insertDeviceStatus(sql, param);

        return isInsert;

    }

    //查看运行故障设备的服务----->查看所有运行状态不正常的设备方法
    public List<DeviceStatus> queryRunFaultDevice(){

        DeviceStatusDao deviceStatusDao = new DeviceStatusDao();

        String sql = "select id,status,status_date from device_status " +
                "where status = '不正常'";

        List<DeviceStatus> deviceStatuses = deviceStatusDao.queryRunFaultDevice(sql);

        return deviceStatuses;

    }

    //查看运行状态为正在修理中的设备的服务----->查询正在修理中的设备信息
    public List<DeviceStatus> fixingDeviceQuery(){

        String sql = "select * from device_status where " +
                "status = '正在报修'";

        //(这个服务对device_status单表操作，所以使用DeviceStatusDao)
        //查询正在修理中的设备信息
        DeviceStatusDao deviceStatusDao = new DeviceStatusDao();
        List<DeviceStatus> deviceStatuses = deviceStatusDao.fixingDeviceQuery(sql);

        return deviceStatuses;

    }



    //根据id查看设备运行状态服务----->根据id查看库内设备运行状态的方法
    public List<DeviceStatus> queryDeviceStatusById(Object... param){

        //(这个服务对device_status单表操作，所以使用DeviceStatusDao)
        DeviceStatusDao deviceStatusDao = new DeviceStatusDao();

        String sql = "select * from device_status where id = ?";

        List<DeviceStatus> deviceStatuses = deviceStatusDao.queryDeviceStatusById(sql, param);

        return deviceStatuses;
    }



    //根据id修改设备运行状态服务------->根据id修改库内设备运行状态的方法
    public boolean updateDeviceStatusById(Object... param){

        //(这个方法对device_status单表操作，所以使用DeviceStatusDao)
        DeviceStatusDao deviceStatusDao = new DeviceStatusDao();
        Connection con;

        String sql1 = "update device_status set status = ? where id = ?";
        String sql2 = "update device_status set status_date = ? where id = ?";
        try {
            con = DbUtil.getCon();
            con.setAutoCommit(false);//此时开启了事务

            //先修改状态
            boolean isUpdate1 = deviceStatusDao.updateDeviceStatusById(sql1, param[2], param[0]);

            //再修改日期
            boolean isUpdate2 = deviceStatusDao.updateDeviceStatusById(sql2, param[1], param[0]);

            con.commit();//提交事务

            if(isUpdate1 && isUpdate2){
                return true;
            }else {
                return false;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);//将编译异常转换成运行异常，抛出
        }


    }




    //根据设备运行年月日查看设备运行状态服务------->根据设备运行年月日查看设备运行状态的方法
    //****注意！！！****//
    //服务说明：
    // 使用该服务，判断条件的参数要传两遍，也就是24个参数，参数可以是默认值但不能为空！
    public List<MultiTableBean> queryDeviceStatusByYearMonthDay(Object... param){


        //(这个服务对device_library表和device_status表联合查询，所以使用MultiTableDao)
        MultiTableDao multiTableDao = new MultiTableDao();

        //输入日期
        if("".equals(param[22])&&"".equals(param[23])) {

            String sql1 = "select device_status.* from device_status,device_library where " +
                    "device_status.id = device_library.id " +
                    "and (type = ? or ? = '暂无') " +
                    "and (model = ? or ? = '暂无' ) " +
                    "and (spec = ? or ? = '暂无') " +
                    "and (money = ? or ? = '暂无') " +
                    "and (num = ? or ? = '暂无') " +
                    "and (date = ? or ? = '暂无') " +
                    "and (factory = ? or ? = '暂无') " +
                    "and (buyer = ? or ? = '暂无') " +
                    "and (batch = ? or ? = 1) " +
                    "and (device_library.crname = ? or ? = '暂无') " +
                    "and (status = ? or ? = '暂无') " +
                    "and (status_date like concat('%','.' , '%' , '.' , ?) or ? = '暂无')";


            List<MultiTableBean> multiTableBeans = multiTableDao.queryDeviceStatusByOthers(sql1,
                    param[0], param[1], param[2], param[3], param[4], param[5], param[6], param[7], param[8]
                    , param[9], param[10], param[11], param[12], param[13], param[14], param[15], param[16], param[17]
                    , param[18], param[19], param[20], param[21], param[24], param[25]);
            return multiTableBeans;


        }else if("".equals(param[22])&&"".equals(param[24])) {//输入月份

            String sql1 = "select device_status.* from device_status,device_library where " +
                    "device_status.id = device_library.id " +
                    "and (type = ? or ? = '暂无') " +
                    "and (model = ? or ? = '暂无' ) " +
                    "and (spec = ? or ? = '暂无') " +
                    "and (money = ? or ? = '暂无') " +
                    "and (num = ? or ? = '暂无') " +
                    "and (date = ? or ? = '暂无') " +
                    "and (factory = ? or ? = '暂无') " +
                    "and (buyer = ? or ? = '暂无') " +
                    "and (batch = ? or ? = 1) " +
                    "and (device_library.crname = ? or ? = '暂无') " +
                    "and (status = ? or ? = '暂无') " +
                    "and (status_date like concat('%','.' , ? , '.' , '%') or ? = '暂无')";


            List<MultiTableBean> multiTableBeans = multiTableDao.queryDeviceStatusByOthers(sql1,
                    param[0], param[1], param[2], param[3], param[4], param[5], param[6], param[7], param[8]
                    , param[9], param[10], param[11], param[12], param[13], param[14], param[15], param[16], param[17]
                    , param[18], param[19], param[20], param[21], param[23], param[25]);
            return multiTableBeans;

        }else if("".equals(param[23])&&"".equals(param[24])){//输入年份

            String sql1 = "select device_status.* from device_status,device_library where " +
                    "device_status.id = device_library.id " +
                    "and (type = ? or ? = '暂无') " +
                    "and (model = ? or ? = '暂无' ) " +
                    "and (spec = ? or ? = '暂无') " +
                    "and (money = ? or ? = '暂无') " +
                    "and (num = ? or ? = '暂无') " +
                    "and (date = ? or ? = '暂无') " +
                    "and (factory = ? or ? = '暂无') " +
                    "and (buyer = ? or ? = '暂无') " +
                    "and (batch = ? or ? = 1) " +
                    "and (device_library.crname = ? or ? = '暂无') " +
                    "and (status = ? or ? = '暂无') " +
                    "and (status_date like concat( ?, '.' , '%' , '.' , '%') or ? = '暂无')";


            List<MultiTableBean> multiTableBeans = multiTableDao.queryDeviceStatusByOthers(sql1,
                    param[0], param[1], param[2], param[3], param[4], param[5], param[6], param[7], param[8]
                    , param[9], param[10], param[11], param[12], param[13], param[14], param[15], param[16], param[17]
                    , param[18], param[19], param[20], param[21], param[22], param[25]);
            return multiTableBeans;

        }else if(!("".equals(param[22]))&&!("".equals(param[23]))&&"".equals(param[24])){//输入年份月份

            String sql1 = "select device_status.* from device_status,device_library where " +
                    "device_status.id = device_library.id " +
                    "and (type = ? or ? = '暂无') " +
                    "and (model = ? or ? = '暂无' ) " +
                    "and (spec = ? or ? = '暂无') " +
                    "and (money = ? or ? = '暂无') " +
                    "and (num = ? or ? = '暂无') " +
                    "and (date = ? or ? = '暂无') " +
                    "and (factory = ? or ? = '暂无') " +
                    "and (buyer = ? or ? = '暂无') " +
                    "and (batch = ? or ? = 1) " +
                    "and (device_library.crname = ? or ? = '暂无') " +
                    "and (status = ? or ? = '暂无') " +
                    "and (status_date like concat( ?, '.' , ? , '.' , '%') or ? = '暂无')";


            List<MultiTableBean> multiTableBeans = multiTableDao.queryDeviceStatusByOthers(sql1,
                    param[0], param[1], param[2], param[3], param[4], param[5], param[6], param[7], param[8]
                    , param[9], param[10], param[11], param[12], param[13], param[14], param[15], param[16], param[17]
                    , param[18], param[19], param[20], param[21], param[22], param[23],param[25]);
            return multiTableBeans;

        }else if(!("".equals(param[22]))&&"".equals(param[23])&&!("".equals(param[24]))){//输入年份日

            String sql1 = "select device_status.* from device_status,device_library where " +
                    "device_status.id = device_library.id " +
                    "and (type = ? or ? = '暂无') " +
                    "and (model = ? or ? = '暂无' ) " +
                    "and (spec = ? or ? = '暂无') " +
                    "and (money = ? or ? = '暂无') " +
                    "and (num = ? or ? = '暂无') " +
                    "and (date = ? or ? = '暂无') " +
                    "and (factory = ? or ? = '暂无') " +
                    "and (buyer = ? or ? = '暂无') " +
                    "and (batch = ? or ? = 1) " +
                    "and (device_library.crname = ? or ? = '暂无') " +
                    "and (status = ? or ? = '暂无') " +
                    "and (status_date like concat( ?, '.' , '%', '.' , ?) or ? = '暂无')";


            List<MultiTableBean> multiTableBeans = multiTableDao.queryDeviceStatusByOthers(sql1,
                    param[0], param[1], param[2], param[3], param[4], param[5], param[6], param[7], param[8]
                    , param[9], param[10], param[11], param[12], param[13], param[14], param[15], param[16], param[17]
                    , param[18], param[19], param[20], param[21], param[22],param[24],param[25]);
            return multiTableBeans;

        }else {//输入月份日

            String sql1 = "select device_status.* from device_status,device_library where " +
                    "device_status.id = device_library.id " +
                    "and (type = ? or ? = '暂无') " +
                    "and (model = ? or ? = '暂无' ) " +
                    "and (spec = ? or ? = '暂无') " +
                    "and (money = ? or ? = '暂无') " +
                    "and (num = ? or ? = '暂无') " +
                    "and (date = ? or ? = '暂无') " +
                    "and (factory = ? or ? = '暂无') " +
                    "and (buyer = ? or ? = '暂无') " +
                    "and (batch = ? or ? = 1) " +
                    "and (device_library.crname = ? or ? = '暂无') " +
                    "and (status = ? or ? = '暂无') " +
                    "and (status_date like concat( '%', '.' , ? , '.' , ?) or ? = '暂无')";


            List<MultiTableBean> multiTableBeans = multiTableDao.queryDeviceStatusByOthers(sql1,
                    param[0], param[1], param[2], param[3], param[4], param[5], param[6], param[7], param[8]
                    , param[9], param[10], param[11], param[12], param[13], param[14], param[15], param[16], param[17]
                    , param[18], param[19], param[20], param[21], param[23], param[24],param[25]);
            return multiTableBeans;

        }

    }



    //根据设备其他信息查看设备运行状态服务------->根据设备其他信息查看设备运行状态的方法
    //****注意！！！****//
    //服务说明：
    // 使用该服务，判断条件的参数要传两遍，也就是24个参数，参数可以是默认值但不能为空！
    public List<MultiTableBean> queryDeviceStatusByOthers(Object... param){

        //(这个服务对device_library表和device_status表联合查询，所以使用MultiTableDao)
        MultiTableDao multiTableDao = new MultiTableDao();

        String sql1 = "select device_status.* from device_status,device_library where " +
                "device_status.id = device_library.id " +
                "and (type = ? or ? = '暂无') " +
                "and (model = ? or ? = '暂无' ) " +
                "and (spec = ? or ? = '暂无') " +
                "and (money = ? or ? = '暂无') " +
                "and (num = ? or ? = '暂无') " +
                "and (date = ? or ? = '暂无') " +
                "and (factory = ? or ? = '暂无') " +
                "and (buyer = ? or ? = '暂无') " +
                "and (batch = ? or ? = 1) " +
                "and (device_library.crname = ? or ? = '暂无') " +
                "and (status = ? or ? = '暂无') " +
                "and (status_date = ? or ? = '暂无')";


        List<MultiTableBean> multiTableBeans = multiTableDao.queryDeviceStatusByOthers(sql1,param);

        return multiTableBeans;


    }



    //根据设备其他信息修改设备运行状态的方法
    //****注意！！！****//
    //服务说明：
    // 使用该服务，判断条件的参数要传两遍，也就是24个参数，修改值为最后一个参数，传一遍，参数可以是默认值但不能为空！
    public boolean updateDeviceStatusByOthers(Object... param){

        //(这个方法对device_library表和device_status表联合查询，所以使用MultiTableDao)
        MultiTableDao multiTableDao = new MultiTableDao();

        String sql = "update device_status as ds1 , " +
                "(select device_status.id from device_status ,device_library where " +
                "device_status.id = device_library.id " +
                "and (type = ? or ? = '暂无') " +
                "and (model = ? or ? = '暂无' )" +
                "and (spec = ? or ? = '暂无')" +
                "and (money = ? or ? = '暂无')" +
                "and (num = ? or ? = '暂无')" +
                "and (date = ? or ? = '暂无')" +
                "and (factory = ? or ? = '暂无')" +
                "and (buyer = ? or ? = '暂无')" +
                "and (batch = ? or ? = 1)" +
                "and (crname = ? or ? = '暂无')" +
                "and (status = ? or ? = '暂无')" +
                "and (status_date = ? or ? = '暂无') as ds2 " +
                "set status = ? where ds1.id = ds2.id";

        boolean isUpdate = multiTableDao.updateDeviceStatusByOthers(sql, param);
        return isUpdate;

    }




}
