package DbCurriculumDesign.LaboratoryEquipmentManagement.dao;

import DbCurriculumDesign.LaboratoryEquipmentManagement.model.MultiTableBean;

import java.util.List;

//这是用于运行表和设备表联合查询操作的Dao

public class MultiTableDao extends DmlBasicDao<MultiTableBean>{

    //根据设备其他信息查询设备运行情况的方法
    public List<MultiTableBean> queryDeviceStatusByOthers(String sql, Object... param){

        return this.queryMulti(sql, MultiTableBean.class, param);

    }

    //根据设备其他信息修改设备运行状态的方法
    public boolean updateDeviceStatusByOthers(String sql,Object... param){

        int update = this.update(sql,param);

        if ((update >0)) {
            return true;
        }else {
            return false;
        }
    }


}
