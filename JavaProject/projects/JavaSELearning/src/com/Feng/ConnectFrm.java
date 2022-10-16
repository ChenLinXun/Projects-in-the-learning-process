package com.Feng;
import com.mysql.jdbc.Driver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectFrm extends JFrame {

    private JPanel jPanel;
    private JButton button;

    Connection con;

    public static void main(String[] args) {

        new ConnectFrm();

    }

    public ConnectFrm() throws HeadlessException {

        jPanel = new JPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        button = new JButton("连接");
        button.setBackground(new Color(255, 239, 213));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                try {
                    //注册驱动
                    Driver driver = new Driver();
                    //获取连接
                    //数据库地址(stu_db01 是数据库名，要改一下)
                    String url = "jdbc:mysql://localhost:3306/stu_db01";
                    Properties properties = new Properties();
                    properties.setProperty("user","root");//获取账户
                    //(记得一下自己mysql的密码)
                    properties.setProperty("password","Socialbigfeng321");
                    con = driver.connect(url,properties);//获取连接
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


                if(con != null){
                    System.out.println("连接成功");
                }

            }
        });

        add(jPanel);
        add(button);
        setVisible(true);


    }




}
