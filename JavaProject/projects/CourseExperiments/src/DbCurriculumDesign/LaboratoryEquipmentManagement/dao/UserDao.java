package DbCurriculumDesign.LaboratoryEquipmentManagement.dao;

import DbCurriculumDesign.LaboratoryEquipmentManagement.model.User;


//用户登录Dao类，获取来自登录server传来的sql语句及其参数，完成登录工作

public class UserDao extends DmlBasicDao<User> {
    //登录验证
    public boolean login(String sql,Object... param) {

        User user = this.querySingle(sql, User.class, param);
        if(user != null){
            return true;
        }else {
            return false;
        }

    }


}
