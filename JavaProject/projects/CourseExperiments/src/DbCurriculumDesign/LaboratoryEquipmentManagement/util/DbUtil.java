package DbCurriculumDesign.LaboratoryEquipmentManagement.util;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;

//连接获取和关闭工具

public class DbUtil {

    private  static String jdbcName="com.mysql.jdbc.Driver";//驱动名称

    public static Connection getCon() throws Exception{
        Class.forName(jdbcName);//自动完成注册驱动
        Properties properties = new Properties();
        properties.load(new FileReader("src\\DbCurriculumDesign\\LaboratoryEquipmentManagement\\dbconnect.properties"));
        Connection con=DriverManager.getConnection(properties.getProperty("dbUrl"),properties.getProperty("dbUserName"),properties.getProperty("dbPassword"));
        return con;
    }

    public static void close(ResultSet set, Statement statement, Connection con){

        try {
            if(set != null){
                set.close();
            }
            if(statement != null){
                statement.close();
            }
            if(con != null){
                con.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);//将编译异常转换成运行异常，抛出
        }

    }

}

