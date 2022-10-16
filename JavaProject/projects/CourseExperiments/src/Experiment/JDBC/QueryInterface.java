package Experiment.JDBC;

import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Vector;

public class QueryInterface extends JFrame implements ActionListener{

    //GUI相关属性
    JTextField sidTf;
    JTextField classTf;
    JTextField snameTf;
    JTextField sdpTf;
    JTextField sageTf1;
    JTextField sageTf2;
    JTextField saddressTf;
    JTextField ssexTf;
    JTextArea sqlSentenceJta;
    JCheckBox sidJcb;
    JCheckBox classJcb;
    JCheckBox snameJcb;
    JCheckBox sdpJcb;
    JCheckBox sageJcb;
    JLabel sageJL;
    JCheckBox saddressJcb;
    JCheckBox ssexJcb;

    //查询条件选中标记（默认未选中）
    boolean sidFlag = false;
    boolean classFlag = false;
    boolean snameFlag = false;
    boolean sdpFlag = false;
    boolean sageFlag = false;
    boolean saddressFlag = false;
    boolean ssexFlag = false;
    boolean inputFalse = true;

    //sql语句属性
    String Sql = "select * from student";

    //mysql连接属性
    MysqlConnect mysqlConnect;
    Connection connection;

    //操控sql的statement对象属性
    Statement statement;

    //查询结果集属性
    ResultSet resultSet;

    //创建一个集合，用于存放用户选择了那些查询条件
    ArrayList<String> choices = new ArrayList<String>();

    //查询结果表头集合
    Vector<String> columnNames = new Vector<String>();

    //查询结果表格模型
    DefaultTableModel tableModel;


    //构造器,绘制界面
    public QueryInterface() {

        //*******绘制界面********//
        //***创建以下下组件***//
        //1.建立窗体
        setLayout(null);
        setBounds(200, 0, 900, 650);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //2.建立面板
        //(1)建立输入信息面板，承载输入信息的部分
        JPanel jPanel = new JPanel();

        //(2)建立查询结果表头面板，用于展示查询属性
        JPanel searchBoxPanel = new JPanel();

        //(3)建立可滚动面板，用于展示查询结果
        // 创建指定列名和数据的表格
        columnNames.add("学号");
        columnNames.add("班级");
        columnNames.add("姓名");
        columnNames.add("系别");
        columnNames.add("年龄");
        columnNames.add("地址");
        columnNames.add("性别");
        //建立表格模型
        tableModel=new DefaultTableModel(columnNames,0);//创建表格模型
        //创建表格并设置表格模型
        JTable table=new JTable(tableModel);

        //创建可滑动面板并放入表格
        JScrollPane jScrollPane = new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);


        //3.创建复选框和标签
        sidJcb = new JCheckBox("学号");
        sidJcb.addItemListener(new MyItemListener());

        classJcb = new JCheckBox("班级");
        classJcb.addItemListener(new MyItemListener());

        snameJcb = new JCheckBox("姓名");
        snameJcb.addItemListener(new MyItemListener());

        sdpJcb = new JCheckBox("系别");
        sdpJcb.addItemListener(new MyItemListener());

        sageJcb = new JCheckBox("年龄自");
        sageJcb.addItemListener(new MyItemListener());

        sageJL = new JLabel("到");

        saddressJcb = new JCheckBox("地址");
        saddressJcb.addItemListener(new MyItemListener());

        ssexJcb = new JCheckBox("性别");
        ssexJcb.addItemListener(new MyItemListener());

        //4.创建文本框
        //(1)输入部分文本框
        sidTf = new JTextField();
        classTf = new JTextField();
        snameTf = new JTextField();
        sdpTf = new JTextField();
        sageTf1 = new JTextField();
        sageTf2 = new JTextField();
        saddressTf = new JTextField();
        ssexTf = new JTextField();
        //(2)sql语句显示文本域
        sqlSentenceJta = new JTextArea();
        sqlSentenceJta.setFont(new Font("宋体",Font.BOLD,15));
        sqlSentenceJta.setLineWrap(true);

        //5.创建按钮
        JButton queryBt = new JButton("查询");
        queryBt.addActionListener(this);
        queryBt.setActionCommand("查询");


        //***将组件组合***//
        //1.组合主要的两个大面板
        add(jPanel);
        add(jScrollPane);
        jPanel.setBounds(0,0,900,300);
        jScrollPane.setBounds(0,320,885,290);
        //2.组合查询面板上的组件
        //添加复选框和对应的文本框
        jPanel.setLayout(null);
        jPanel.add(sidJcb);
        sidJcb.setBounds(50,0,50,50);
        jPanel.add(sidTf);
        sidTf.setBounds(101,10,150,30);

        jPanel.add(classJcb);
        classJcb.setBounds(450,0,50,50);
        jPanel.add(classTf);
        classTf.setBounds(501,10,50,30);

        jPanel.add(snameJcb);
        snameJcb.setBounds(50,50,50,50);
        jPanel.add(snameTf);
        snameTf.setBounds(101,60,100,30);

        jPanel.add(sdpJcb);
        sdpJcb.setBounds(450,50,50,50);
        jPanel.add(sdpTf);
        sdpTf.setBounds(501,60,150,30);

        jPanel.add(sageJcb);
        sageJcb.setBounds(50,100,70,50);
        jPanel.add(sageTf1);
        sageTf1.setBounds(121,110,30,30);

        jPanel.add(sageJL);
        sageJL.setBounds(200,100,50,50);
        jPanel.add(sageTf2);
        sageTf2.setBounds(251,110,30,30);

        jPanel.add(saddressJcb);
        saddressJcb.setBounds(450,100,50,50);
        jPanel.add(saddressTf);
        saddressTf.setBounds(501,110,200,30);

        jPanel.add(ssexJcb);
        ssexJcb.setBounds(50,150,50,50);
        jPanel.add(ssexTf);
        ssexTf.setBounds(101,160,30,30);

        jPanel.add(sqlSentenceJta);
        sqlSentenceJta.setBounds(50,200,800,100);

        jPanel.add(queryBt);
        queryBt.setBounds(740,40,100,100);


        //3.组合查询结果面板上的组件
        searchBoxPanel.add(table.getTableHeader(),BorderLayout.NORTH);
        //mainPanel.add(searchBoxPanel,BorderLayout.NORTH);
        //mainPanel.add(jScrollPane,BorderLayout.CENTER);


        //设置窗体可见
        setVisible(true);

    }

    //用于执行Sql语句的方法
    public void QueryInstruction()throws SQLException{
        //*******sql操作*******//
        //获取连接
        mysqlConnect = new MysqlConnect();
        connection = mysqlConnect.Connect();
        //拿到Statement对象
        statement = connection.createStatement();
        //执行语句拿到结果集
        resultSet = statement.executeQuery(Sql);
        // 数据列表
        Vector<Vector<Object>> rowData = new Vector<Vector<Object>>();
        while (resultSet.next()){
            //对每条记录的每一列进行操作，打印到结果面板上
            //System.out.println(resultSet.getInt(1));//测试
            Vector<Object> rowItem = new Vector<Object>();
            rowItem.add(resultSet.getInt(1));
            rowItem.add(resultSet.getString(2));
            rowItem.add(resultSet.getInt(3));
            rowItem.add(resultSet.getString(4));
            rowItem.add(resultSet.getInt(5));
            rowItem.add(resultSet.getString(6));
            rowItem.add(resultSet.getString(7));
            rowData.add(rowItem);
        }

        // 绑定结果
        tableModel.setDataVector(rowData, columnNames);
        //断开连接
        connection.close();
    }

    //设置查询按钮的事件监听
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("查询")) {
            //判断查询条件是否选中，被选中的将内容加到集合choices中
            if (sidFlag==true && !sidTf.getText().equals("")) {
                choices.add(" s_id="+sidTf.getText());
                inputFalse = false;
            }else if(sidFlag==false && sidTf.getText().equals("")){

            }else{
                JOptionPane.showMessageDialog(null, "输入错误！");
                inputFalse = true;
            }

            if (classFlag==true && !classTf.getText().equals("")) {
                choices.add(" s_class="+classTf.getText());
                inputFalse = false;
            }else if(classFlag==false && classTf.getText().equals("")){

            }else{
                JOptionPane.showMessageDialog(null, "输入错误！");
                inputFalse = true;
            }

            if (snameFlag==true && !snameTf.getText().equals("")) {
                choices.add(" s_name="+"\""+snameTf.getText()+"\"");
                inputFalse = false;
            }else if(snameFlag==false && snameTf.getText().equals("")){

            }else{
                JOptionPane.showMessageDialog(null, "输入错误！");
                inputFalse = true;
            }

            if (sdpFlag==true && !sdpTf.getText().equals("")) {
                choices.add(" s_department="+"\""+sdpTf.getText()+"\"");
                inputFalse = false;
            }else if(sdpFlag==false && sdpTf.getText().equals("")){

            }else{
                JOptionPane.showMessageDialog(null, "输入错误！");
                inputFalse = true;
            }

            if (sageFlag==true && !sageTf1.getText().equals("") && sageTf2.getText().equals("")) {
                choices.add(" s_age="+sageTf1.getText());
                inputFalse = false;
            }else if(sageFlag==false && sageTf1.getText().equals("") && sageTf2.getText().equals("")){

            }else if (sageFlag==true && !sageTf1.getText().equals("") && !sageTf2.getText().equals("")){
                choices.add(" s_age"+" between "+sageTf1.getText()+" and "+sageTf2.getText());
                inputFalse = false;
            }else {
                JOptionPane.showMessageDialog(null, "输入错误！");
                inputFalse = true;
            }

            if (saddressFlag==true && !saddressTf.getText().equals("")) {
                choices.add(" s_address like "+"\'"+"%"+saddressTf.getText()+"%"+"\'");
                inputFalse = false;
            }else if(saddressFlag==false && saddressTf.getText().equals("")){

            }else{
                JOptionPane.showMessageDialog(null, "输入错误！");
                inputFalse = true;
            }

            if(ssexFlag==true && !ssexTf.getText().equals("")){
                if (ssexTf.getText().equals("男") || ssexTf.getText().equals("女")) {
                    choices.add(" s_sex=" + "\"" + ssexTf.getText() + "\"");
                    inputFalse = false;
                }else{
                    JOptionPane.showMessageDialog(null, "性别输入错误！");
                    inputFalse = true;
                }
            }else if(ssexFlag==false && ssexTf.getText().equals("")){

            }else{
                JOptionPane.showMessageDialog(null, "输入错误！");
                inputFalse = true;
            }

            //修改Sql语句
            if(!choices.isEmpty() && !inputFalse){
                //删去重复项
                HashSet<String> set = new HashSet<String>(choices);
                ArrayList<String> newChoices = new ArrayList<String>(set);
                //修改
                Sql = Sql+" where"+newChoices.get(0);
                for(int i=1;i<newChoices.size();i++){
                   Sql = Sql+" and"+newChoices.get(i);
                }
                sqlSentenceJta.setText(Sql);
            }

            //调用Sql语句执行方法进行查询
            try {
                if (!inputFalse) {
                    QueryInstruction();
                    choices.clear();
                    Sql = "select* from student";
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }


    //用于为查询条件进行标记的内部类
    class MyItemListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            if (e.getItem().equals(sidJcb)) {
                // 推断是否被选择
                sidFlag= sidJcb.isSelected();
            }else if(e.getItem().equals(classJcb)){
                if (classJcb.isSelected()) {// 推断是否被选择
                    classFlag=true;
                } else {
                    classFlag=false;
                }
            }else if(e.getItem().equals(snameJcb)){
                if (snameJcb.isSelected()) {// 推断是否被选择
                    snameFlag=true;
                } else {
                    snameFlag=false;
                }
            }else if(e.getItem().equals(sdpJcb)){
                if (sdpJcb.isSelected()) {// 推断是否被选择
                    sdpFlag=true;
                } else {
                    sdpFlag=false;
                }
            }else if(e.getItem().equals(sageJcb)){
                if (sageJcb.isSelected()) {// 推断是否被选择
                    sageFlag=true;
                } else {
                    sageFlag=false;
                }
            }else if(e.getItem().equals(saddressJcb)){
                if (saddressJcb.isSelected()) {// 推断是否被选择
                    saddressFlag=true;
                } else {
                    saddressFlag=false;
                }
            }else if(e.getItem().equals(ssexJcb)){
                if (ssexJcb.isSelected()) {// 推断是否被选择
                    ssexFlag=true;
                } else {
                    ssexFlag=false;
                }
            }
        }
    }
}
