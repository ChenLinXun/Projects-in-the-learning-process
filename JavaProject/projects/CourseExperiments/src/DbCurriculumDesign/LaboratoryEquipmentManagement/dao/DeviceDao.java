package DbCurriculumDesign.LaboratoryEquipmentManagement.dao;

import DbCurriculumDesign.LaboratoryEquipmentManagement.model.LibraryDevice;
import DbCurriculumDesign.LaboratoryEquipmentManagement.util.DbUtil;

import java.sql.Connection;
import java.util.List;

public class DeviceDao extends DmlBasicDao<LibraryDevice> {

    //1.查看库中所有设备信息的方法
    public List<LibraryDevice> deviceAllQuery(String sql){//sql语句由server层传入

        List<LibraryDevice> libraryDevices = this.queryMulti(sql, LibraryDevice.class);

        System.out.println("=======启动了查询库全部信息=======");
        return libraryDevices;

    }

    //2.向库中增加设备的方法1(输入批次信息的情况)
    public boolean deviceInsert1(String sql,Object... param){

        Connection con = null;

        //这里的sql是业务需求需要，定死的，而与server层根据服务组织sql不同
        //因为定死了入库设备时要建立它的设备状态

        String sql1 = "Insert into device_status values(?,'已停止可正常运行',?,?)";

        int update = 0;
        int update1 = 0;
        try {
            con = DbUtil.getCon();
            con.setAutoCommit(false);//此时开启了事务

            //先将信息插入
            update = this.update(sql,param);

            //然后在运行表中将这个设备插入并设置运行状态为：已停止可正常运行
            update1 = this.update(sql1, param[1],param[6],param[10]);

            con.commit();//提交事务

        } catch (Exception e) {
            throw new RuntimeException(e);//将编译异常转换成运行异常，抛出
        }

        if ((update > 0) && (update1 > 0)) {
            return true;
        }else {
            return false;
        }
    }

    //3.向库中增加设备的方法2（不输入批次信息的情况）
    public boolean deviceInsert2(String sql,Object... param){

        Connection con = null;

        //这里的sql是业务需求需要，定死的，而与server层根据服务组织sql不同
        //因为定死了入库设备时要根据 品牌、类型、型号 来确定批次,并且建立它的设备状态

        String sql2 = "select batch from device_library where type=? and model=? ";

        String sql3 = "update device_library set batch= ? +1 where id=?";

        String sql4 = "Insert into device_status values(?,'正常',?,?)";

        int update = 0;
        int update1 = 0;

        try {
            con = DbUtil.getCon();
            con.setAutoCommit(false);//此时开启了事务


            //先查出批次信息中的最大批次
            List<LibraryDevice> libraryDevices = this.queryMulti(sql2, LibraryDevice.class, param[0],param[2]);
            int max=0;
            for (LibraryDevice lb : libraryDevices) {
                if(lb.getBatch()>max){
                    max = lb.getBatch();
                }
            }

            //先将信息插入
            this.update(sql,param);

            //根据最大批次值修改插入设备的批次信息
            update = this.update(sql3, max, param[1]);

            //最后在运行表中将这个设备插入并设置运行状态为：正常
            update1 = this.update(sql4, param[1],param[6],param[10]);

            con.commit();//提交事务

        } catch (Exception e) {
            throw new RuntimeException(e);//将编译异常转换成运行异常，抛出
        }

        if((update > 0) && (update1 > 0)){
            return true;
        }else {
            return false;
        }

    }



}
