package DbCurriculumDesign.LaboratoryEquipmentManagement.dao;

import DbCurriculumDesign.LaboratoryEquipmentManagement.model.DeviceStatus;

import java.util.List;

public class DeviceStatusDao extends DmlBasicDao<DeviceStatus>  {


    //插入一个设备运行状态的方法
    public boolean insertDeviceStatus(String sql,Object... param){

        int isInsert = this.update(sql, param);

        if(isInsert > 0){
            return true;
        }else {
            return false;
        }

    }

    //查看所有运行状态不正常的设备方法
    public List<DeviceStatus> queryRunFaultDevice(String sql, Object... param){

        return this.queryMulti(sql, DeviceStatus.class, param);

    }

    //查询正在修理中的设备信息
    public List<DeviceStatus> fixingDeviceQuery(String sql, Object... param){

        return this.queryMulti(sql, DeviceStatus.class, param);

    }


    //根据id查看库内设备运行状态的方法
    public List<DeviceStatus> queryDeviceStatusById(String sql, Object... param){

        return this.queryMulti(sql, DeviceStatus.class, param);

    }

    //根据id修改库内设备运行状态的方法
    public boolean updateDeviceStatusById(String sql,Object... param){

        int update = this.update(sql,param);

        if ((update >0)) {
            return true;
        }else {
            return false;
        }
    }



}
