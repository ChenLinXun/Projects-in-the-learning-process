package DbCurriculumDesign.LaboratoryEquipmentManagement.view;


import DbCurriculumDesign.LaboratoryEquipmentManagement.server.DeviceScrapServer;
import DbCurriculumDesign.LaboratoryEquipmentManagement.util.StringUtil;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class AddScrapDeviceFrm extends JFrame {

    private JPanel contentPane;
    private JTextField yearTF;
    private JTextField monthTF;
    private JTextField dayTF;
    private JTextField dnameTF;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddScrapDeviceFrm frame = new AddScrapDeviceFrm();
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
    public AddScrapDeviceFrm() {
        setTitle("添加报废设备界面");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 808, 479);
        contentPane = new JPanel();
        contentPane.setBackground(Color.PINK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("报废日期：");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));

        yearTF = new JTextField();
        yearTF.setFont(new Font("宋体", Font.PLAIN, 15));
        yearTF.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("年");
        lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));

        monthTF = new JTextField();
        monthTF.setFont(new Font("宋体", Font.PLAIN, 15));
        monthTF.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("月");
        lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 20));

        dayTF = new JTextField();
        dayTF.setFont(new Font("宋体", Font.PLAIN, 15));
        dayTF.setColumns(10);

        JLabel lblNewLabel_1_1_1 = new JLabel("日");
        lblNewLabel_1_1_1.setFont(new Font("宋体", Font.PLAIN, 20));

        JLabel lblNewLabel_2 = new JLabel("设备名：");
        lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));

        dnameTF = new JTextField();
        dnameTF.setFont(new Font("宋体", Font.PLAIN, 15));
        dnameTF.setColumns(10);

        JButton btnNewButton1 = new JButton("添加");
        btnNewButton1.setFont(new Font("宋体", Font.PLAIN, 20));
        btnNewButton1.setBackground(new Color(255, 240, 245));
        btnNewButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    AddScrapActionPerformed(e);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });


        JButton btnNewButton2 = new JButton("返回设备报废界面");
        btnNewButton2.setFont(new Font("宋体", Font.PLAIN, 20));
        btnNewButton2.setBackground(new Color(255, 240, 245));
        btnNewButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ToMainFixFrmActionPerformed();
            }
        });

        JButton btnNewButton3 = new JButton("返回主界面");
        btnNewButton3.setFont(new Font("宋体", Font.PLAIN, 20));
        btnNewButton3.setBackground(new Color(255, 240, 245));
        btnNewButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ToMainFrmActionPerformed();
            }
        });
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(41)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(156)
                                                .addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(dnameTF, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
                                                .addComponent(btnNewButton1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                                                .addGap(89))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(lblNewLabel)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(yearTF, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(monthTF, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                                .addGap(10)
                                                .addComponent(dayTF, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18)
                                                .addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(204, Short.MAX_VALUE))))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(88)
                                .addComponent(btnNewButton2)
                                .addGap(116)
                                .addComponent(btnNewButton3, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                .addGap(204))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(54)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                .addComponent(yearTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(lblNewLabel_1)
                                                                .addComponent(monthTF, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(dayTF, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(38)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(dnameTF, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                                .addGap(125))
                                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                                .addContainerGap(136, Short.MAX_VALUE)
                                                .addComponent(btnNewButton1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                                .addGap(124)))
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(btnNewButton2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnNewButton3, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(87, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
        this.setLocationRelativeTo(null);
    }


    //添加报废设备
    private void AddScrapActionPerformed(ActionEvent evt) throws Exception{

        String year = this.yearTF.getText();
        String month = this.monthTF.getText();
        String day = this.dayTF.getText();
        String id= this.dnameTF.getText();
        String scrap_date = "暂无";


        if (StringUtil.isEmpty(year)) {
            JOptionPane.showMessageDialog(null, "设备名和报废日期不能为空");
            return;
        }
        if (StringUtil.isEmpty(month)) {
            JOptionPane.showMessageDialog(null, "设备名和报废日期不能为空");
            return;
        }
        if (StringUtil.isEmpty(day)) {
            JOptionPane.showMessageDialog(null, "设备名和报废日期不能为空");
            return;
        }
        if (StringUtil.isEmpty(id)) {
            JOptionPane.showMessageDialog(null, "设备名和报废日期不能为空");
            return;
        }

        if((StringUtil.isNotEmpty(year))&&(StringUtil.isNotEmpty(month))&&(StringUtil.isNotEmpty(day))) {

            scrap_date = year + "." + month + "." + day;
        }


        DeviceScrapServer deviceScrapServer = new DeviceScrapServer();
        boolean isInsert = deviceScrapServer.scrapDeviceInsert(id,scrap_date);


        if (isInsert) {
            JOptionPane.showMessageDialog(null, "报废成功！");
            resetValue();
        } else {
            JOptionPane.showMessageDialog(null, "报废失败！");
        }


    }


    //重置事件处理
    private void  resetValue(){
        this.yearTF.setText("");
        this.monthTF.setText("");
        this.dayTF.setText("");
        this.dnameTF.setText("");



    }

    private void ToMainFrmActionPerformed() {
        dispose();
        new MainFrm().setVisible(true);
    }

    private void ToMainFixFrmActionPerformed() {
        dispose();
        new DeviceScrapMainFrm().setVisible(true);
    }

}
