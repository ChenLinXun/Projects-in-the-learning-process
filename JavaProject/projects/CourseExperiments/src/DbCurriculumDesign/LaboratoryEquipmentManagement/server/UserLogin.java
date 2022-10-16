package DbCurriculumDesign.LaboratoryEquipmentManagement.server;

import DbCurriculumDesign.LaboratoryEquipmentManagement.dao.UserDao;
import DbCurriculumDesign.LaboratoryEquipmentManagement.model.User;


//这是一个用于登录的服务,这里用来组织登录服务的sql语句然后调用UserDao来完成登录
public class UserLogin {

    private String sql = "select *from login where userName = ? and password = ?";

    UserDao userDao = new UserDao();

    public UserLogin() {
    }

    public boolean Login(Object... param){

        boolean islogin = userDao.login(sql, param);
        return islogin;

    }



}
