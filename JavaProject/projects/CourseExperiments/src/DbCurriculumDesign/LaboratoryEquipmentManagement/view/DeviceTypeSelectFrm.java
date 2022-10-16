package DbCurriculumDesign.LaboratoryEquipmentManagement.view;


import DbCurriculumDesign.LaboratoryEquipmentManagement.model.LibraryDevice;
import DbCurriculumDesign.LaboratoryEquipmentManagement.server.LibDeviceServer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;


public class DeviceTypeSelectFrm extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JButton btnNewButton;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DeviceTypeSelectFrm frame = new DeviceTypeSelectFrm();
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
    public DeviceTypeSelectFrm() {
        setTitle("入库管理信息");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 961, 443);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JScrollPane scrollPane = new JScrollPane();


        table = new JTable();
        table.setBackground(new Color(255, 175, 175));
        table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "类别", "设备名", "型号", "规格", "单价", "数量", "购置日期", "生产厂家", "购买人", "批次","机房名称"
                }
        ));
        table.getColumnModel().getColumn(0).setPreferredWidth(55);
        table.getColumnModel().getColumn(1).setPreferredWidth(59);
        table.getColumnModel().getColumn(2).setPreferredWidth(53);
        table.getColumnModel().getColumn(3).setPreferredWidth(51);
        table.getColumnModel().getColumn(4).setPreferredWidth(54);
        table.getColumnModel().getColumn(5).setPreferredWidth(50);
        table.getColumnModel().getColumn(6).setPreferredWidth(92);
        table.getColumnModel().getColumn(7).setPreferredWidth(150);
        table.getColumnModel().getColumn(8).setPreferredWidth(50);
        table.getColumnModel().getColumn(9).setPreferredWidth(50);
        scrollPane.setViewportView(table);
        scrollPane.setViewportView(table);

        this.fillTable();

        btnNewButton = new JButton("返回主界面");
        btnNewButton.setBackground(Color.pink);
        btnNewButton.setIcon(new ImageIcon("src\\DbCurriculumDesign\\LaboratoryEquipmentManagement\\resources\\返回.png"));
        btnNewButton.setFont(new Font("等线", Font.PLAIN, 24));
        this.setLocationRelativeTo(null);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ToMainFrmActionPerformed(e);

            }
        });
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 937, Short.MAX_VALUE))
                                .addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);

    }

    //返回主菜单
    private void ToMainFrmActionPerformed(ActionEvent e) {
        dispose();
        new MainFrm().setVisible(true);
    }


    //初始化表格
    private  void fillTable(){

        DefaultTableModel dtm=(DefaultTableModel) table.getModel();
        dtm.setRowCount(0);

        LibDeviceServer libDeviceServer = new LibDeviceServer();
        List<LibraryDevice> libraryDevices = libDeviceServer.deviceAllQuery();


        for (int i = 0; i < libraryDevices.size(); i++) {
            Vector v=new Vector();
            v.add(libraryDevices.get(i).getType());
            v.add(libraryDevices.get(i).getId());
            v.add(libraryDevices.get(i).getModel());
            v.add(libraryDevices.get(i).getSpec());
            v.add(libraryDevices.get(i).getMoney());
            v.add(libraryDevices.get(i).getNum());
            v.add(libraryDevices.get(i).getDate());
            v.add(libraryDevices.get(i).getFactory());
            v.add(libraryDevices.get(i).getBuyer());
            v.add(libraryDevices.get(i).getBatch());
            v.add(libraryDevices.get(i).getCrname());
            dtm.addRow(v);
        }

    }




}
