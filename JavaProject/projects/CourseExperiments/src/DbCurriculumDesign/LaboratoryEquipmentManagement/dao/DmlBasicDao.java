package DbCurriculumDesign.LaboratoryEquipmentManagement.dao;



import DbCurriculumDesign.LaboratoryEquipmentManagement.util.DbUtil;
import java.sql.Connection;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;


//这是一个通用的基本Dao类，完成基本的增删改查功能
//dao包下的其他Dao类可以基于这个基本类来进行设计

public class DmlBasicDao<T> {

    private QueryRunner qr = new QueryRunner();


    //通用更新方法（插入，修改，删除）
    public int update(String sql,Object... parameters){

        Connection con = null;

        try {
            con = DbUtil.getCon();
            return qr.update(con,sql,parameters);

        } catch (Exception e) {
            throw new RuntimeException(e);//将编译异常转换成运行异常，抛出
        } finally {
            DbUtil.close(null,null,con);
        }

    }


    //通用查询(结果多行)方法
    public List<T> queryMulti(String sql, Class<T> clazz, Object... parameters){

        Connection con = null;

        try {
            con = DbUtil.getCon();
            return qr.query(con, sql, new BeanListHandler<T>(clazz), parameters);

        } catch (Exception e) {
            throw new RuntimeException(e);//将编译异常转换成运行异常，抛出
        } finally {
            DbUtil.close(null,null,con);
        }

    }


    //通用查询(结果单行)方法  (这个方法在登录时使用，其他情况下暂时不用，因为返回的不是集合，不太方便在gui处理)
    public T querySingle(String sql, Class<T> clazz, Object... parameters){

        Connection con = null;

        try {
            con = DbUtil.getCon();
            return qr.query(con, sql, new BeanHandler<T>(clazz), parameters);

        } catch (Exception e) {
            throw new RuntimeException(e);//将编译异常转换成运行异常，抛出
        } finally {
            DbUtil.close(null,null,con);
        }

    }


    //通用查询(结果单行单列)方法
    public Object queryScalar(String sql, Class<T> clazz, Object... parameters){

        Connection con = null;

        try {
            con = DbUtil.getCon();
            return qr.query(con,sql,new ScalarHandler<>(),parameters);

        } catch (Exception e) {
            throw new RuntimeException(e);//将编译异常转换成运行异常，抛出
        } finally {
            DbUtil.close(null,null,con);
        }

    }



}
