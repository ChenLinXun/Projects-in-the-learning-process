package DbCurriculumDesign.LaboratoryEquipmentManagement.server;

import DbCurriculumDesign.LaboratoryEquipmentManagement.dao.DeviceDao;
import DbCurriculumDesign.LaboratoryEquipmentManagement.model.LibraryDevice;

import java.util.List;

public class LibDeviceServer {


    //查看库存服务-------->查看库中所有设备的方法
    public List<LibraryDevice> deviceAllQuery(){

        DeviceDao deviceDao = new DeviceDao();

        String sql = "select * from device_library";

        List<LibraryDevice> libraryDevices = deviceDao.deviceAllQuery(sql);

        return libraryDevices;

    }


    //2.设备入库服务------>向库中增加设备的方法
    //****注意！！！****//
    //服务说明：
    // 这个服务要求传入所有的11条设备信息，信息可以为空或者为默认值，但必须传入！
    public boolean deviceInsert(Object... param){

        DeviceDao deviceDao = new DeviceDao();

        String sql = "Insert into device_library values(?,?,?,?,?,?,?,?,?,?,?)";

        if(Integer.parseInt(String.valueOf(param[9])) == 1){//如果没有输入批次信息则使用第二种插入方法
            return deviceDao.deviceInsert2(sql, param);

        }else {//如果输入了批次信息则使用第一种插入方法
            return deviceDao.deviceInsert1(sql, param);

        }

    }


}
