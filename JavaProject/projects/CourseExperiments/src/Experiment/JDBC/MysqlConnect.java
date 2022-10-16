package Experiment.JDBC;


import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class MysqlConnect {

    public Connection Connect() throws SQLException {
        //注册驱动
        Driver driver = new Driver();
        //获取连接
        String url = "jdbc:mysql://localhost:3306/stu_db01";//数据库地址
        Properties properties = new Properties();
        properties.setProperty("user","root");//获取账户
        properties.setProperty("password","Socialbigfeng321");//获取密码
        Connection connect = driver.connect(url,properties);//获取连接
        System.out.println(connect);
        return connect;
    }

}
