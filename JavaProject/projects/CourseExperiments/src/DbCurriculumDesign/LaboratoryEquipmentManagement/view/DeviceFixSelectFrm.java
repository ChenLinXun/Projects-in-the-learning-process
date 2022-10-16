package DbCurriculumDesign.LaboratoryEquipmentManagement.view;



import DbCurriculumDesign.LaboratoryEquipmentManagement.model.DeviceFix;
import DbCurriculumDesign.LaboratoryEquipmentManagement.model.DeviceStatus;
import DbCurriculumDesign.LaboratoryEquipmentManagement.model.MultiTableBean;
import DbCurriculumDesign.LaboratoryEquipmentManagement.server.DeviceFixServer;
import DbCurriculumDesign.LaboratoryEquipmentManagement.util.StringUtil;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

public class DeviceFixSelectFrm extends JFrame {

    private JPanel factoryTF;
    private JTextField nameTF;
    private JTextField textField_1;
    private JTextField yearTF;
    private JTextField monthTF;
    private JTextField dayTF;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DeviceFixSelectFrm frame = new DeviceFixSelectFrm();
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
    public DeviceFixSelectFrm() {
        setTitle("查询设备报修情况界面");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 895, 605);
        factoryTF = new JPanel();
        factoryTF.setBackground(Color.PINK);
        factoryTF.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(factoryTF);

        JLabel lblNewLabel = new JLabel("设备名：");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));

        nameTF = new JTextField();
        nameTF.setFont(new Font("宋体", Font.PLAIN, 16));
        nameTF.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("修理厂家：");
        lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));

        textField_1 = new JTextField();
        textField_1.setFont(new Font("宋体", Font.PLAIN, 16));
        textField_1.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("修理日期：");
        lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));

        yearTF = new JTextField();
        yearTF.setFont(new Font("宋体", Font.PLAIN, 16));
        yearTF.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("");

        JLabel lblNewLabel_4 = new JLabel("年");
        lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 20));

        monthTF = new JTextField();
        monthTF.setFont(new Font("宋体", Font.PLAIN, 16));
        monthTF.setColumns(10);

        JLabel lblNewLabel_4_1 = new JLabel("月");
        lblNewLabel_4_1.setFont(new Font("宋体", Font.PLAIN, 20));

        dayTF = new JTextField();
        dayTF.setFont(new Font("宋体", Font.PLAIN, 16));
        dayTF.setColumns(10);

        JLabel lblNewLabel_4_1_1 = new JLabel("日");
        lblNewLabel_4_1_1.setFont(new Font("宋体", Font.PLAIN, 20));

        JScrollPane scrollPane = new JScrollPane();

        JButton btnNewButton = new JButton("返回主界面");
        btnNewButton.setBackground(new Color(255, 245, 238));
        btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ToMainFrmActionPerformed(e);
            }
        });

        JButton btnNewButton_1 = new JButton("查询");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SelectActionPerformed(e);

            }
        });
        btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
        btnNewButton_1.setBackground(new Color(255, 245, 238));
        GroupLayout gl_factoryTF = new GroupLayout(factoryTF);
        gl_factoryTF.setHorizontalGroup(
                gl_factoryTF.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_factoryTF.createSequentialGroup()
                                .addGroup(gl_factoryTF.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_factoryTF.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 837, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_factoryTF.createSequentialGroup()
                                                .addGap(317)
                                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(24, Short.MAX_VALUE))
                        .addGroup(gl_factoryTF.createSequentialGroup()
                                .addGap(49)
                                .addGroup(gl_factoryTF.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(gl_factoryTF.createSequentialGroup()
                                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                                .addGap(20))
                                        .addGroup(gl_factoryTF.createSequentialGroup()
                                                .addComponent(lblNewLabel_2)
                                                .addPreferredGap(ComponentPlacement.RELATED)))
                                .addGroup(gl_factoryTF.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_factoryTF.createSequentialGroup()
                                                .addComponent(yearTF, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addGroup(gl_factoryTF.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_factoryTF.createSequentialGroup()
                                                                .addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(monthTF, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                .addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(dayTF, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(lblNewLabel_4_1_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                                .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                                                .addGap(103))
                                        .addGroup(gl_factoryTF.createSequentialGroup()
                                                .addComponent(nameTF, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                                .addGap(94)
                                                .addComponent(lblNewLabel_1)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(193, Short.MAX_VALUE))))
        );
        gl_factoryTF.setVerticalGroup(
                gl_factoryTF.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_factoryTF.createSequentialGroup()
                                .addGroup(gl_factoryTF.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_factoryTF.createSequentialGroup()
                                                .addGroup(gl_factoryTF.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_factoryTF.createSequentialGroup()
                                                                .addGap(41)
                                                                .addGroup(gl_factoryTF.createParallelGroup(Alignment.BASELINE)
                                                                        .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(nameTF, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(gl_factoryTF.createSequentialGroup()
                                                                .addGap(45)
                                                                .addGroup(gl_factoryTF.createParallelGroup(Alignment.LEADING)
                                                                        .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))))
                                                .addGap(36)
                                                .addGroup(gl_factoryTF.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(yearTF, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNewLabel_3)
                                                        .addComponent(lblNewLabel_4)
                                                        .addComponent(monthTF, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(dayTF, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNewLabel_4_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                                .addGap(41)
                                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_factoryTF.createSequentialGroup()
                                                .addGap(96)
                                                .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE))
        );

        table = new JTable();
        table.setBackground(Color.PINK);
        table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "设备名", "修理厂家", "修理日期", "修理费用","责任人"
                }
        ));
        scrollPane.setViewportView(table);
        factoryTF.setLayout(gl_factoryTF);
        this.setLocationRelativeTo(null);
    }


    //返回主页面
    private void ToMainFrmActionPerformed(ActionEvent e) {
        dispose();
        new MainFrm().setVisible(true);
    }


    //查询报修情况
    private void SelectActionPerformed(ActionEvent evt) {

        String year = this.yearTF.getText();
        String month = this.monthTF.getText();
        String day = this.dayTF.getText();
        String fix_date = "暂无";
        String id = "暂无";
        String fix_factory = "暂无";

        if((StringUtil.isNotEmpty(this.nameTF.getText()))){
            id = this.nameTF.getText();
        }

        if(StringUtil.isNotEmpty(this.textField_1.getText())){
            fix_factory = this.textField_1.getText();
        }


        DeviceFixServer deviceFixServer = new DeviceFixServer();

        if(!StringUtil.isNotEmpty(this.nameTF.getText())) {

            if((StringUtil.isNotEmpty(year))||(StringUtil.isNotEmpty(month))||(StringUtil.isNotEmpty(day))) {
                fix_date = year + "." + month + "." + day;

                List<DeviceFix> deviceFixes = deviceFixServer.queryDeviceFixByYearMonthDay(fix_factory, fix_factory, year, month, day, fix_date);
                this.fillTable(deviceFixes);

            }else{
                List<DeviceFix> deviceFixes = deviceFixServer.fixDeviceQuery(id, id, fix_factory, fix_factory, fix_date, fix_date);
                this.fillTable(deviceFixes);
            }

        }else{
            List<DeviceFix> deviceFixes = deviceFixServer.fixDeviceQuery(id, id, fix_factory, fix_factory, fix_date, fix_date);
            this.fillTable(deviceFixes);
        }

        this.resetValue();

    }



    private void fillTable(List<DeviceFix> deviceFix) {

        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);


        for (int i = 0; i < deviceFix.size(); i++) {
            Vector v=new Vector();
            v.add(deviceFix.get(i).getId());
            v.add(deviceFix.get(i).getFix_factory());
            v.add(deviceFix.get(i).getFix_date());
            v.add(deviceFix.get(i).getFix_money());
            v.add(deviceFix.get(i).getDutyer());
            dtm.addRow(v);
        }


    }

    private void resetValue() {
        this.nameTF.setText("");
        this.textField_1.setText("");
        this.yearTF.setText("");
        this.monthTF.setText("");
        this.dayTF.setText("");

    }



}
