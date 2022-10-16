package DbCurriculumDesign.LaboratoryEquipmentManagement.view;

import DbCurriculumDesign.LaboratoryEquipmentManagement.model.DeviceFix;
import DbCurriculumDesign.LaboratoryEquipmentManagement.model.DeviceScrap;
import DbCurriculumDesign.LaboratoryEquipmentManagement.server.DeviceScrapServer;
import DbCurriculumDesign.LaboratoryEquipmentManagement.util.StringUtil;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class DeviceScrapSelectFrm extends JFrame {

    private JPanel panel;
    private JTextField nameTF;
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
                    DeviceScrapSelectFrm frame = new DeviceScrapSelectFrm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     * Create the frame.
     */
    public DeviceScrapSelectFrm() {
        setTitle("查询设备报废情况");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 719, 618);
        panel = new JPanel();
        panel.setBackground(Color.PINK);
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel);

        JLabel lblNewLabel = new JLabel("设备名：");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));

        nameTF = new JTextField();
        nameTF.setFont(new Font("宋体", Font.PLAIN, 16));
        nameTF.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("报废日期：");
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
        
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
                gl_panel.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 665, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_panel.createSequentialGroup()
                                                .addGap(72)
                                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(gl_panel.createSequentialGroup()
                                                                .addGap(140)
                                                                .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(20, Short.MAX_VALUE))
                        .addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
                                .addGap(45)
                                .addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
                                        .addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
                                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(nameTF, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
                                                .addComponent(lblNewLabel_2)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(yearTF, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(monthTF, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(dayTF, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(lblNewLabel_4_1_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(122, Short.MAX_VALUE))
        );
        gl_panel.setVerticalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addGap(21)
                                .addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(lblNewLabel_3)
                                        .addGroup(gl_panel.createSequentialGroup()
                                                .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(nameTF, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
                                                .addGap(6)))
                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel.createSequentialGroup()
                                                .addGap(8)
                                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
                                                        .addGroup(gl_panel.createSequentialGroup()
                                                                .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                                                                        .addComponent(yearTF, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lblNewLabel_4))
                                                                .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
                                                                .addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(44)))
                                                .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(gl_panel.createSequentialGroup()
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(monthTF, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(dayTF, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNewLabel_4_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))))
                                .addGap(55)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE))
        );


        table = new JTable();
        table.setBackground(Color.PINK);
        table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "设备名",  "类型", "型号", "报废日期","入库日期"
                }
        ));
        scrollPane.setViewportView(table);
        panel.setLayout(gl_panel);
        this.setLocationRelativeTo(null);
    }


    //返回主菜单
    private void ToMainFrmActionPerformed(ActionEvent e) {
        dispose();
        new MainFrm().setVisible(true);
    }

    
    //查询设备报废情况
    private void SelectActionPerformed(ActionEvent evt) {

        String year = this.yearTF.getText();
        String month = this.monthTF.getText();
        String day = this.dayTF.getText();
        String scrap_date = "暂无";
        String id = "暂无";

        if((StringUtil.isNotEmpty(this.nameTF.getText()))){
            id = this.nameTF.getText();
        }


        DeviceScrapServer deviceScrapServer = new DeviceScrapServer();

        if(!StringUtil.isNotEmpty(this.nameTF.getText())) {

            if((StringUtil.isNotEmpty(year))||(StringUtil.isNotEmpty(month))||(StringUtil.isNotEmpty(day))) {

                scrap_date = year + "." + month + "." + day;

                List<DeviceScrap> deviceScraps = deviceScrapServer.scrapDeviceQueryByYearMonthDay(year, month, day, scrap_date);
                this.fillTable(deviceScraps);

            }

        }else{
            List<DeviceScrap> deviceScraps = deviceScrapServer.scrapDeviceQueryById(id);
            this.fillTable(deviceScraps);
        }

        this.resetValue();

    }



    private void fillTable(List<DeviceScrap> deviceScrapList) {

        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);


        for (int i = 0; i < deviceScrapList.size(); i++) {
            Vector v=new Vector();
            v.add(deviceScrapList.get(i).getId());
            v.add(deviceScrapList.get(i).getType());
            v.add(deviceScrapList.get(i).getModel());
            v.add(deviceScrapList.get(i).getScrap_date());
            v.add(deviceScrapList.get(i).getDate());

            dtm.addRow(v);
        }

    }

    private void resetValue() {
        this.nameTF.setText("");
        this.yearTF.setText("");
        this.monthTF.setText("");
        this.dayTF.setText("");

    }



}
