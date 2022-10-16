package DbCurriculumDesign.LaboratoryEquipmentManagement.dao;

import DbCurriculumDesign.LaboratoryEquipmentManagement.model.MultiTableBean2;

import java.util.List;

//这是用于报修表和设备表联合查询操作的Dao

public class MultiTable2Dao extends DmlBasicDao<MultiTableBean2> {

    //根据设备的其他信息查询报修情况的方法
    public List<MultiTableBean2> fixDeviceQueryByOthers(String sql , Object... param){

        List<MultiTableBean2> multiTableBean2s = this.queryMulti(sql, MultiTableBean2.class, param);

        return multiTableBean2s;

    }


}
