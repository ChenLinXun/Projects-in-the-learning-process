package com.feng;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Demo {

    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        Properties pp = new Properties();
        pp.load(new FileReader("src\\dbconnect.properties"));

        Connection conn = DriverManager.getConnection
                (pp.getProperty("dbUrl"), pp.getProperty("dbUserName"), pp.getProperty("dbPassword"));

        String sql = "select * from login where userName = ? and password = ?";

        PreparedStatement ps = conn.prepareStatement(sql);

        //SQL注入没用啦~~~
        //ps.setString(1,"1' or");
        //ps.setString(2,"or '1'= '1");

        ps.setString(1,"kitty");
        ps.setString(2,"123456");

        ResultSet rs = ps.executeQuery();

        while (rs.next()){
            String s1 = rs.getString(2);//第一列是主键id
            String s2 = rs.getString(3);
            System.out.println("账号："+ s1 + "，密码：" + s2);
        }

    }

}
