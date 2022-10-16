package DbCurriculumDesign.LaboratoryEquipmentManagement.view;


import DbCurriculumDesign.LaboratoryEquipmentManagement.model.DeviceStatus;
import DbCurriculumDesign.LaboratoryEquipmentManagement.server.DeviceStatusServer;

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



public class DeviceScrapMainFrm extends JFrame {

    private JPanel contentPane;
    private JTable table;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DeviceScrapMainFrm frame = new DeviceScrapMainFrm();
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
    public DeviceScrapMainFrm() {
        setTitle("报废设备主页面");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 929, 569);
        contentPane = new JPanel();
        contentPane.setBackground(Color.PINK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JScrollPane scrollPane = new JScrollPane();

        JButton btnNewButton = new JButton("添加报废设备");
        btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
        btnNewButton.setBackground(new Color(255, 240, 245));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ToAddScrapFrmActionPerformed();
            }
        });

        JButton btnNewButton_1 = new JButton("查询设备报废情况");
        btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
        btnNewButton_1.setBackground(new Color(255, 240, 245));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ToSelectScrapFrmActionPerformed();
            }
        });
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 905, Short.MAX_VALUE)
                        .addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
                                .addGap(91)
                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                                .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
                                .addGap(149))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
                                .addGap(78)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(119, Short.MAX_VALUE))
        );

        table = new JTable();
        table.setBackground(Color.PINK);
        table.setFont(new Font("宋体", Font.PLAIN, 13));
        table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "设备名称","日期", "运行状况"
                }
        ));
        table.getColumnModel().getColumn(0).setPreferredWidth(55);
        table.getColumnModel().getColumn(1).setPreferredWidth(59);
        table.getColumnModel().getColumn(2).setPreferredWidth(59);
        scrollPane.setViewportView(table);
        contentPane.setLayout(gl_contentPane);

        this.fillTable();
        this.setLocationRelativeTo(null);


    }

    //进入查询设备报废情况页面
    private void ToSelectScrapFrmActionPerformed() {
        dispose();
        new DeviceScrapSelectFrm().setVisible(true);

    }

    //进入添加报废设备页面
    private void ToAddScrapFrmActionPerformed() {
        dispose();
        new AddScrapDeviceFrm().setVisible(true);
    }


    private  void fillTable(){

        DefaultTableModel dtm=(DefaultTableModel) table.getModel();
        dtm.setRowCount(0);

        List<DeviceStatus> deviceStatuses = new DeviceStatusServer().fixingDeviceQuery();


        for (int i = 0; i < deviceStatuses.size(); i++) {
            Vector v=new Vector();
            v.add(deviceStatuses.get(i).getId());
            v.add(deviceStatuses.get(i).getStatus_date());
            v.add(deviceStatuses.get(i).getStatus());
            dtm.addRow(v);
        }

    }


}