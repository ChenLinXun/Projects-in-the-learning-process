package DbCurriculumDesign.LaboratoryEquipmentManagement.view;


import DbCurriculumDesign.LaboratoryEquipmentManagement.model.DeviceStatus;
import DbCurriculumDesign.LaboratoryEquipmentManagement.model.MultiTableBean;
import DbCurriculumDesign.LaboratoryEquipmentManagement.server.DeviceStatusServer;
import DbCurriculumDesign.LaboratoryEquipmentManagement.util.StringUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;


/**
     * Launch the application.
     */


    /**
     * Create the frame.
     */
    public class DeviceRunSelectFrm extends JFrame {

        private JPanel contentPane;
        private JTextField dnameTF;
        private JTextField crnameTF;
        private JTextField yearTF;
        private JLabel lblNewLabel_1_2;
        private JTextField monthTF;
        private JTextField dayTF;
        private JLabel lblNewLabel_1_3;
        private JButton btnNewButton;
        private JButton btnNewButton_1;
        private JButton btnNewButton_2;
        private JTable table;


        /**
         * Launch the application.
         */
        public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        DeviceRunSelectFrm frame = new DeviceRunSelectFrm();
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        /**
         * Create the frame.
         */
        public DeviceRunSelectFrm() {
            setBackground(Color.WHITE);
            setTitle("设备运行状况查询");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 885, 719);
            contentPane = new JPanel();
            contentPane.setBackground(Color.PINK);
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);

            JLabel lblNewLabel = new JLabel("设备名称：");
            lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 23));

            dnameTF = new JTextField();
            dnameTF.setColumns(10);

            JLabel lblNewLabel_2 = new JLabel("机房名称：");
            lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 23));

            crnameTF = new JTextField();
            crnameTF.setColumns(10);

            JLabel lblNewLabel_1 = new JLabel("日期：");
            lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 23));

            yearTF = new JTextField();
            yearTF.setColumns(10);

            JLabel lblNewLabel_1_1 = new JLabel("年");
            lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 23));

            lblNewLabel_1_2 = new JLabel("月");
            lblNewLabel_1_2.setFont(new Font("宋体", Font.PLAIN, 23));

            monthTF = new JTextField();
            monthTF.setColumns(10);

            dayTF = new JTextField();
            dayTF.setColumns(10);

            lblNewLabel_1_3 = new JLabel("日");
            lblNewLabel_1_3.setFont(new Font("宋体", Font.PLAIN, 23));

            btnNewButton = new JButton("查询");
            btnNewButton.setBackground(new Color(255, 239, 213));
            btnNewButton.setFont(new Font("宋体", Font.PLAIN, 24));
            btnNewButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    SelectActionPerformed(e);
                }
            });

            btnNewButton_1 = new JButton("返回主页面");
            btnNewButton_1.setBackground(new Color(255, 255, 240));
            btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 24));
            btnNewButton_1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ToMainActionPerformed();
                }
            });

            btnNewButton_2 = new JButton("修改运行信息");
            btnNewButton_2.setBackground(new Color(255, 255, 240));
            btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 24));
            btnNewButton_2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ToUpdataActionPerformed();
                }
            });

            JScrollPane scrollPane = new JScrollPane();
            GroupLayout gl_contentPane = new GroupLayout(contentPane);
            gl_contentPane.setHorizontalGroup(
                    gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(gl_contentPane.createSequentialGroup()
                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                    .addGap(59)
                                                    .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(yearTF, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(monthTF, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(38))
                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                    .addContainerGap()
                                                    .addComponent(lblNewLabel)
                                                    .addGap(18)
                                                    .addComponent(dnameTF, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(110)
                                                    .addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(13)))
                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                    .addGap(20)
                                                    .addComponent(crnameTF, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(dayTF, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18)
                                                    .addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(83)
                                    .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(36, Short.MAX_VALUE))
                            .addGroup(gl_contentPane.createSequentialGroup()
                                    .addContainerGap(158, Short.MAX_VALUE)
                                    .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                                    .addGap(128)
                                    .addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                    .addGap(198))
                            .addGroup(gl_contentPane.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 841, Short.MAX_VALUE)
                                    .addContainerGap())
            );
            gl_contentPane.setVerticalGroup(
                    gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(gl_contentPane.createSequentialGroup()
                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                    .addGap(23)
                                                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                            .addComponent(crnameTF, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                    .addGap(26)
                                                                    .addComponent(dnameTF, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
                                                    .addGap(18)
                                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                            .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(yearTF, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(dayTF, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(monthTF, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                            .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                                                    .addGap(15))
                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                    .addGap(36)
                                                    .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(40)
                                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap())
            );

            table = new JTable();
            table.setFont(new Font("楷体", Font.PLAIN, 15));
            table.setModel(new DefaultTableModel(
                    new Object[][]{
                    },
                    new String[]{
                            "设备名称", "机房名称", "日期", "设备运行状况"
                    }
            ));
            table.setBackground(Color.PINK);
            scrollPane.setViewportView(table);

            JScrollBar scrollBar = new JScrollBar();
            scrollPane.setRowHeaderView(scrollBar);
            contentPane.setLayout(gl_contentPane);
            this.setLocationRelativeTo(null);
        }


        //查询
        private void SelectActionPerformed(ActionEvent evt) {

            String id = this.dnameTF.getText();        //用户输入值
            String year = this.yearTF.getText();       //用户输入值
            String month = this.monthTF.getText();     //用户输入值
            String day = this.dayTF.getText();        //用户输入值
            String crname = "暂无";                   //用户输入值
            String date = "暂无";                     //用户输入值（根据year、month、day拼接）
            String status = "暂无";
            String type = "暂无";
            String model = "暂无";
            String spec = "暂无";
            String money = "暂无";
            String num = "暂无";
            String status_date = "暂无";
            String factory = "暂无";
            String buyer = "暂无";
            int batch = 1;

            DeviceStatusServer deviceStatusServer = new DeviceStatusServer();

            if(StringUtil.isNotEmpty(this.crnameTF.getText())) {
                crname = this.crnameTF.getText();
            }


            if(!StringUtil.isNotEmpty(this.dnameTF.getText())) {

                if((StringUtil.isNotEmpty(year))||(StringUtil.isNotEmpty(month))||(StringUtil.isNotEmpty(day))) {
                    status_date = year + "." + month + "." + day;

                    List<MultiTableBean> multiTableBeans = deviceStatusServer.queryDeviceStatusByYearMonthDay(type, type, model, model, spec, spec, money, money,
                            num, num, date, date, factory, factory, buyer, buyer, batch, batch, crname, crname,
                            status, status, year, month, day, status_date);

                    this.fillTable1(multiTableBeans);

                }else{
                    List<MultiTableBean> multiTableBeans = deviceStatusServer.queryDeviceStatusByOthers(type, type, model, model, spec, spec, money, money,
                            num, num, date, date, factory, factory, buyer, buyer, batch, batch, crname, crname,
                            status, status, status_date, status_date);
                    this.fillTable1(multiTableBeans);
                }

            }else {
                List<DeviceStatus> deviceStatuses = deviceStatusServer.queryDeviceStatusById(id);
                this.fillTable2(deviceStatuses);
            }

            this.resetValue();

        }


        //返回主菜单
        private void ToMainActionPerformed() {
            dispose();
            new MainFrm().setVisible(true);
        }

        //进入修改运行状态页面
        private void ToUpdataActionPerformed() {
            dispose();
            new DeviceRunUpdataFrm().setVisible(true);
        }



        private void fillTable1(List<MultiTableBean> multiTableBeanList) {

            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);


            for (int i = 0; i < multiTableBeanList.size(); i++) {
                Vector v=new Vector();
                v.add(multiTableBeanList.get(i).getId());
                v.add(multiTableBeanList.get(i).getCrname());
                v.add(multiTableBeanList.get(i).getStatus_date());
                v.add(multiTableBeanList.get(i).getStatus());
                dtm.addRow(v);
            }

        }

        private void fillTable2(List<DeviceStatus> deviceStatuses) {

            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);


            for (int i = 0; i < deviceStatuses.size(); i++) {
                Vector v=new Vector();
                v.add(deviceStatuses.get(i).getId());
                v.add(deviceStatuses.get(i).getCrname());
                v.add(deviceStatuses.get(i).getStatus_date());
                v.add(deviceStatuses.get(i).getStatus());
                dtm.addRow(v);
            }


        }


        private void resetValue() {

            this.dnameTF.setText("");
            this.crnameTF.setText("");
            this.yearTF.setText("");
            this.monthTF.setText("");
            this.dayTF.setText("");

        }


    }

