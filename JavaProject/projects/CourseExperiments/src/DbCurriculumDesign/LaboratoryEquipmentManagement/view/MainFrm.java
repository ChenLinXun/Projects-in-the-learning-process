package DbCurriculumDesign.LaboratoryEquipmentManagement.view;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrm extends JFrame {


    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrm frame = new MainFrm();
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
    public MainFrm() {
        this.pack();
        setBackground(Color.WHITE);
        setTitle("实验室设备管理主界面");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 760, 450);
        contentPane = new JPanel();
        contentPane.setBackground(Color.PINK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        this.setLocationRelativeTo(null);//设置居中

        JLabel lblNewLabel = new JLabel("欢迎使用实验室设备管理系统");
        lblNewLabel.setFont(new Font("等线", Font.PLAIN, 20));

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("src\\DbCurriculumDesign\\LaboratoryEquipmentManagement\\resources\\实验室管理.png"));

        JButton btnNewButton = new JButton("设备入库管理");
        btnNewButton.setBackground(new Color(255, 245, 238));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddActionPerformed(e);

            }
        });

        JButton btnNewButton_1 = new JButton("报修设备管理");
        btnNewButton_1.setBackground(new Color(255, 245, 238));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               FixActionPerformed(e);

            }
        });


        JButton btnNewButton_2 = new JButton("设备运行状况统计");
        btnNewButton_2.setBackground(new Color(255, 245, 238));
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SelectActionPerformed(e);

            }
        });

        JButton btnNewButton_3 = new JButton("报废设备管理功能");
        btnNewButton_3.setBackground(new Color(255, 245, 238));
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ScrapActionPerformed(e);

            }
        });
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(54)
                                .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
                                        .addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                                .addGap(55)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
                                        .addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                                .addContainerGap(19, Short.MAX_VALUE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap(248, Short.MAX_VALUE)
                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
                                .addGap(210))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(26)
                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(36)
                                                .addComponent(lblNewLabel_1))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(58)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(btnNewButton)
                                                        .addComponent(btnNewButton_2))
                                                .addGap(86)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(btnNewButton_1)
                                                        .addComponent(btnNewButton_3))))
                                .addContainerGap(94, Short.MAX_VALUE))
        );

        contentPane.setLayout(gl_contentPane);
        contentPane.setLayout(gl_contentPane);
    }

    private void ScrapActionPerformed(ActionEvent e) {
        dispose();
        new DeviceScrapMainFrm().setVisible(true);
    }

    private void FixActionPerformed(ActionEvent e) {
        dispose();
        new DeviceFixMainFrm().setVisible(true);
    }

    private void SelectActionPerformed(ActionEvent evt) {
        dispose();
        new DeviceRunSelectFrm().setVisible(true);
    }

    private void AddActionPerformed(ActionEvent e) {
        dispose();
        new AddFrm().setVisible(true);
    }

}
