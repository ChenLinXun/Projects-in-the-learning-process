package DbCurriculumDesign.LaboratoryEquipmentManagement.view;


import DbCurriculumDesign.LaboratoryEquipmentManagement.server.DeviceStatusServer;
import DbCurriculumDesign.LaboratoryEquipmentManagement.util.StringUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;


public class DeviceRunUpdataFrm extends JFrame {

        private JPanel contentPane;
        private JTextField dnameTF;
        private JTextField yearTF;
        private JTextField monthTF;
        private JTextField dayTF;
        private JComboBox drunCB;


    /**
         * Launch the application.
         */
        public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        DeviceRunUpdataFrm frame = new DeviceRunUpdataFrm();
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
        public DeviceRunUpdataFrm() {
            setTitle("修改设备运行界面");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 941, 489);
            contentPane = new JPanel();
            contentPane.setBackground(Color.PINK);
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);

            JLabel lblNewLabel = new JLabel("请输入你想修改的设备名称:");
            lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 24));

            dnameTF = new JTextField();
            dnameTF.setColumns(10);

            JLabel lblNewLabel_1 = new JLabel("输入日期：");
            lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 24));

            yearTF = new JTextField();
            yearTF.setColumns(10);

            JLabel lblNewLabel_2 = new JLabel("年");
            lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 24));

            monthTF = new JTextField();
            monthTF.setColumns(10);

            JLabel lblNewLabel_2_1 = new JLabel("月");
            lblNewLabel_2_1.setFont(new Font("宋体", Font.PLAIN, 24));

            dayTF = new JTextField();
            dayTF.setColumns(10);

            JLabel lblNewLabel_2_1_1 = new JLabel("日");
            lblNewLabel_2_1_1.setFont(new Font("宋体", Font.PLAIN, 24));

            drunCB = new JComboBox();
            drunCB.setSize(100,20);
            drunCB.setBackground(new Color(255, 245, 238));
            drunCB.addItem("正常");
            drunCB.addItem("不正常");




            JLabel lblNewLabel_1_1 = new JLabel("修改运行状况：");
            lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 24));

            JButton btnNewButton = new JButton("返回查询运行状况");
            btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
            btnNewButton.setBackground(new Color(255, 245, 238));
            btnNewButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ToSelectFrmActionPerformed(e);
                }
            });

            JButton btnNewButton_1 = new JButton("返回主界面");
            btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
            btnNewButton_1.setBackground(new Color(255, 245, 238));
            btnNewButton_1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ToMainActionPerformed();
                }
            });

            JButton saveBT = new JButton("保存");
            saveBT.setBackground(new Color(255, 245, 238));
            saveBT.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    UpdateActionPerformed(e);
                }
            });

            GroupLayout gl_contentPane = new GroupLayout(contentPane);
            gl_contentPane.setHorizontalGroup(
                    gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(gl_contentPane.createSequentialGroup()
                                    .addGap(59)
                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                    .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addComponent(yearTF, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                    .addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addComponent(monthTF, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                    .addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                    .addGap(60)
                                                                    .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)))
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(dayTF, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                            .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                    .addGroup(gl_contentPane.createSequentialGroup()
                                                            .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(dnameTF, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(gl_contentPane.createSequentialGroup()
                                                            .addComponent(lblNewLabel_1_1)
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(drunCB, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                                                            .addGap(180)
                                                            .addComponent(saveBT, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))))
                                    .addContainerGap(121, Short.MAX_VALUE))
            );
            gl_contentPane.setVerticalGroup(
                    gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(gl_contentPane.createSequentialGroup()
                                    .addGap(55)
                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dnameTF, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                    .addGap(47)
                                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                            .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(yearTF, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                                                                    .addComponent(lblNewLabel_2))
                                                            .addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)))
                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                    .addGap(46)
                                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                            .addComponent(monthTF, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                    .addGap(45)
                                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                            .addComponent(dayTF, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))))
                                    .addGap(58)
                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(drunCB, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(saveBT, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                                    .addGap(60))
            );
            contentPane.setLayout(gl_contentPane);
            this.setLocationRelativeTo(null);
        }

    private void UpdateActionPerformed(ActionEvent evt) {

        String id = this.dnameTF.getText();
        String year = this.yearTF.getText();
        String month = this.monthTF.getText();
        String day = this.dayTF.getText();

        String status = (String) this.drunCB.getSelectedItem();

        String status_date = "暂无";


        if((StringUtil.isNotEmpty(year))&&(StringUtil.isNotEmpty(month))&&(StringUtil.isNotEmpty(day))){
            status_date=year + "." + month + "." + day;
        }
        if(StringUtil.isEmpty(id)){
            JOptionPane.showMessageDialog(null,"设备名不能为空");
            return;
        }

        boolean isUpdate = new DeviceStatusServer().updateDeviceStatusById(id,status_date,status);


        if(isUpdate){
            JOptionPane.showMessageDialog(null,"修改成功！");
            resetValue();
        }else{
            JOptionPane.showMessageDialog(null,"修改失败！");
        }

    }

    private void resetValue() {

        this.dnameTF.setText("");
        this.yearTF.setText("");
        this.monthTF.setText("");
        this.dayTF.setText("");

    }


    //返回上一级
    private void ToSelectFrmActionPerformed(ActionEvent e) {
        dispose();
        new DeviceRunSelectFrm().setVisible(true);
    }


    //返回主菜单
    private void ToMainActionPerformed() {
        dispose();
        new MainFrm().setVisible(true);
    }


}

