package DbCurriculumDesign.LaboratoryEquipmentManagement.dao;

import DbCurriculumDesign.LaboratoryEquipmentManagement.model.DeviceFix;
import DbCurriculumDesign.LaboratoryEquipmentManagement.model.DeviceStatus;
import DbCurriculumDesign.LaboratoryEquipmentManagement.util.DbUtil;

import java.sql.Connection;
import java.util.List;

public class DeviceFixDao extends DmlBasicDao<DeviceFix> {


    //插入一个报修设备到报修表的方法
    public boolean fixDeviceInsert(String sql,Object... param){

        Connection con = null;

        //这里的sql是业务需求需要，定死的，而与server层根据服务组织sql不同
        //因为定死了报修设备时要修改这个设备在运行表中的设备运行状态

        String sql2 = "update device_status set status = '正在报修' " +
                "where id = ? ";

        int isInsert;
        int isUpdate;
        try {
            con = DbUtil.getCon();
            con.setAutoCommit(false);//此时开启了事务

            //先把这个设备的报修信息插入到报修表中
            isInsert = this.update(sql, param);

            //然后根据这个设备的id修改它的运行状态
            isUpdate = this.update(sql2, param[0]);

            con.commit();//提交事务

        } catch (Exception e) {
            throw new RuntimeException(e);//将编译异常转换成运行异常，抛出
        }

        if((isInsert >0) && (isUpdate >0)){
            return true;
        }else {
            return false;
        }

    }

    //根据设备的id查询设备报修信息的方法
    public List<DeviceFix> fixDeviceQueryById(String sql , Object... param){

        List<DeviceFix> deviceFixes = this.queryMulti(sql,DeviceFix.class,param);

        return  deviceFixes;

    }


    //将已修好的设备反库使用的方法
    public boolean fixDeviceBack(Object... param){

        Connection con;

        String sql1 = "update device_status set status = '已停止可正常运行' where id = ?";

        String sql2 = "delete from device_fix where id = ?";

        int isUpdate1;
        int isUpdate2;
        try {
            con = DbUtil.getCon();
            con.setAutoCommit(false); //此时开启了事务

            //先将这个设备的运行状态改为：已停止可正常运行
            isUpdate1 = this.update(sql1, param);

            //然后将这个设备从报修表中删除
            isUpdate2 = this.update(sql2, param);

            con.commit();//提交事务

        } catch (Exception e) {
            throw new RuntimeException(e); //将编译异常转换成运行异常，抛出
        }

        if((isUpdate1 > 0) && (isUpdate2 >0)){
            return true;
        }else {
            return false;
        }

    }




}
