package DbCurriculumDesign.LaboratoryEquipmentManagement.dao;

import DbCurriculumDesign.LaboratoryEquipmentManagement.model.DeviceScrap;
import DbCurriculumDesign.LaboratoryEquipmentManagement.model.LibraryDevice;
import DbCurriculumDesign.LaboratoryEquipmentManagement.util.DbUtil;

import java.sql.Connection;
import java.util.List;

public class DeviceScrapDao extends DmlBasicDao<DeviceScrap> {

    //插入一个报废设备的方法
    public boolean scrapDeviceInsert(Object... param){

        Connection con = null;

        //这里的sql是业务需求需要，定死的，而与server层根据服务组织sql不同
        //因为定死了报废设备时要从设备表、运行表和报修表删除这个设备

        String sql1 ="Insert into device_scrap values(?,?,?,?,?)";
        String sql2 = "select *from device_library where id = ? ";
        String sql3 = "delete from device_library where id = ?";
        String sql4 = "delete from device_status where id = ?";
        String sql5 = "delete from device_fix where id = ?";

        int isInsert = 0;
        int isUpdate1 = 0;
        int isUpdate2 = 0;
        int isUpdate3 = 0;
        try {
            con = DbUtil.getCon();
            con.setAutoCommit(false);//此时开启了事务

            //先按照id从设备表中获得该报废设备的全部信息
            DeviceDao deviceDao = new DeviceDao();
            List<LibraryDevice> libraryDevices = deviceDao.queryMulti(sql2, LibraryDevice.class, param[0]);

            //再往报废表中插入这个设备的信息
            isInsert = this.update(sql1, param[0],libraryDevices.get(0).getType(),
                    libraryDevices.get(0).getModel(),param[1],libraryDevices.get(0).getDate());

            //最后将这个设备从设备表、运行表和报修表中删除
            isUpdate1 = this.update(sql3, param[0]);
            isUpdate2 = this.update(sql4, param[0]);
            isUpdate3 = this.update(sql5, param[0]);

        } catch (Exception e) {
            throw new RuntimeException(e);//将编译异常转换成运行异常，抛出
        }

        if((isInsert > 0) && (isUpdate1 > 0) && (isUpdate2 > 0) && (isUpdate3 > 0)){
            return true;
        }else {
            return false;
        }

    }



    //根据设备信息查询报废信息的方法
    public List<DeviceScrap> scrapDeviceQueryByAny(String sql , Object... param){

        List<DeviceScrap> deviceScraps = this.queryMulti(sql, DeviceScrap.class, param);
        return deviceScraps;

    }

    //根据设备名或者日期查询报废情况
    public List<DeviceScrap> scrapDeviceQueryByIdOrDate(String sql , Object... param){

        List<DeviceScrap> deviceScraps = this.queryMulti(sql, DeviceScrap.class, param);
        return deviceScraps;

    }



}
