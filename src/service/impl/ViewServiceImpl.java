package service.impl;

import dao.PhonerelationshipDao;
import dao.impl.PhonerelationshipImpl;
import entity.PhonerelationshipEntity;
import service.ViewService;
import utils.Jdialogg;
import utils.Table;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ViewServiceImpl implements ViewService {


    PhonerelationshipDao pdao = new PhonerelationshipImpl();

    @Override
    public void selectAll() {
        String[] title = new String[]{"id", "名字", "电话号码", "创建时间", "修改时间"};
        //将makermembers的信息传入到一个二维数组中即可
        String[][] mess = new String[1000][6];
        int k = 0;
        List<PhonerelationshipEntity> list = pdao.selectAll();

        for (PhonerelationshipEntity phonerelationshipEntity : list) {
            mess[k][0] = phonerelationshipEntity.getId();
            mess[k][1] = phonerelationshipEntity.getName();
            mess[k][2] = phonerelationshipEntity.getPhonenum();
            mess[k][3] = String.valueOf(phonerelationshipEntity.getCreattime());
            mess[k][4] = String.valueOf(phonerelationshipEntity.getUpdatetime());
            k++;
        }
        //建立一个表格
        JTable table = new JTable(mess, title);
        Table miantable = new Table();
        JTableHeader jTableHeader = table.getTableHeader();
        jTableHeader.setPreferredSize(new Dimension(jTableHeader.getWidth(), 32));//表头大小
        jTableHeader.setFont(new Font("楷体", Font.BOLD, 20));//表头的字体，字号
        jTableHeader.setForeground(Color.RED);
        table.setRowHeight(30);//高度
        Container container1 = new Container();
        container1 = miantable.getContentPane();
        JScrollPane sp = new JScrollPane(table);
        container1.add(sp, BorderLayout.CENTER);

    }

    @Override
    public void selectByxx() {

        Jdialogg jdialogg = new Jdialogg();
        Container container1 = new Container();
        container1 = jdialogg.getContentPane();
        JLabel jLabel = new JLabel("请输入你要查询的信息：");
        JTextField jTextField = new JTextField();
        jLabel.setBounds(90, 20, 200, 200);
        jTextField.setBounds(220, 112, 200, 20);
        container1.setLayout(null);//绝对布局
        container1.add(jLabel);
        container1.add(jTextField);
        JButton jButton = new JButton("查询");
        jButton.setBounds(220, 150, 100, 40);
        container1.add(jButton);
        jButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] title = new String[]{"id", "名字", "电话号码", "创建时间", "修改时间"};
                //将makermembers的信息传入到一个二维数组中即可
                String[][] mess = new String[1000][6];
                int k = 0;
                List<PhonerelationshipEntity> list = pdao.selectByIdorName(jTextField.getText());
                for (PhonerelationshipEntity phonerelationshipEntity : list) {
                    mess[k][0] = phonerelationshipEntity.getId();
                    mess[k][1] = phonerelationshipEntity.getName();
                    mess[k][2] = phonerelationshipEntity.getPhonenum();
                    mess[k][3] = String.valueOf(phonerelationshipEntity.getCreattime());
                    mess[k][4] = String.valueOf(phonerelationshipEntity.getUpdatetime());
                    k++;
                }
                if (list.size() != 0) {
                    Table maintable = new Table();
                    Container container2 = maintable.getContentPane();
                    JTable jTable = new JTable(mess, title);
                    JScrollPane sp = new JScrollPane(jTable);
                    container2.add(sp, BorderLayout.CENTER);
                } else {
                    Jdialogg jdialogg1 = new Jdialogg();
                    jdialogg1.setBounds(200, 200, 300, 300);
                    Container container2 = jdialogg1.getContentPane();
                    container2.setLayout(null);//绝对布局
                    JLabel jLabel1 = new JLabel("对不起，找不到此信息成员");
                    jLabel1.setBounds(80, 70, 150, 100);
                    container2.add(jLabel1);
                }
            }
        });
    }


    @Override
    public void delete() {
        Jdialogg jdialogg = new Jdialogg();
        Container container1 = new Container();
        container1 = jdialogg.getContentPane();
        JLabel jLabel = new JLabel("请输入你要删除的id或全名：");
        JTextField jTextField = new JTextField();
        jLabel.setBounds(60, 20, 200, 200);
        jTextField.setBounds(220, 112, 200, 20);
        container1.setLayout(null);//绝对布局
        container1.add(jLabel);
        container1.add(jTextField);
        JButton jButton = new JButton("删除");
        jButton.setBounds(220, 150, 100, 40);
        container1.add(jButton);
        jButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = pdao.deleteById(jTextField.getText());
                if (i != 0) {
                    Jdialogg jdialogg1 = new Jdialogg();
                    jdialogg1.setBounds(200, 200, 300, 300);
                    Container container2 = jdialogg1.getContentPane();
                    container2.setLayout(null);//绝对布局
                    JLabel jLabel1 = new JLabel("成功删除此信息成员");
                    jLabel1.setBounds(80, 70, 150, 100);
                    container2.add(jLabel1);
                } else {
                    Jdialogg jdialogg1 = new Jdialogg();
                    jdialogg1.setBounds(200, 200, 300, 300);
                    Container container2 = jdialogg1.getContentPane();
                    container2.setLayout(null);//绝对布局
                    JLabel jLabel1 = new JLabel("对不起，找不到此信息成员");
                    jLabel1.setBounds(80, 70, 150, 100);
                    container2.add(jLabel1);
                }
            }
        });
    }

    @Override
    public void update() {

        Jdialogg jdialog1 = new Jdialogg();//建立了一个弹窗
        //建立标签
        JLabel jLabel1 = new JLabel("   修改后成员的名字：");
        JLabel jLabel2 = new JLabel("修改成员的手机号：");
        //建立的是文本框
        JLabel jLabel = new JLabel("   修改成员的id号：");
        JTextField jTextField = new JTextField();
        JTextField jTextField1 = new JTextField();
        JTextField jTextField2 = new JTextField();
        //进行输入的存储
        //文本框1
        //建立一个保存的按钮
        JButton jButton = new JButton("修改信息");
        jButton.setBounds(220, 360, 100, 40);
        jTextField.setBounds(200, 112, 200, 20);
        jTextField1.setBounds(200, 152, 200, 20);
        jTextField2.setBounds(200, 192, 200, 20);
        //标签的位置
        jLabel.setBounds(100, 20, 200, 200);
        jLabel1.setBounds(80, 60, 200, 200);
        jLabel2.setBounds(90, 100, 200, 200);
        //放入容器内
        Container container1 = jdialog1.getContentPane();
        container1.setLayout(null);
        container1.add(jLabel1);
        container1.add(jLabel2);
        container1.add(jLabel);
        container1.add(jTextField1);
        container1.add(jTextField2);
        container1.add(jTextField);
        container1.add(jButton);
        jButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PhonerelationshipEntity entity = new PhonerelationshipEntity(jTextField.getText(), jTextField1.getText(), jTextField2.getText(), new Date());
                int i = pdao.updateById(entity);
                if (i != 0) {
                    Jdialogg jdialogg1 = new Jdialogg();
                    jdialogg1.setBounds(200, 200, 300, 300);
                    Container container2 = jdialogg1.getContentPane();
                    container2.setLayout(null);//绝对布局
                    JLabel jLabel11 = new JLabel("成功修改此信息成员");
                    jLabel11.setBounds(80, 70, 150, 100);
                    container2.add(jLabel11);
                } else {
                    Jdialogg jdialogg1 = new Jdialogg();
                    jdialogg1.setBounds(200, 200, 300, 300);
                    Container container2 = jdialogg1.getContentPane();
                    container2.setLayout(null);//绝对布局
                    JLabel jLabel11 = new JLabel("对不起，找不到此信息成员");
                    jLabel11.setBounds(80, 70, 150, 100);
                    container2.add(jLabel11);
                }
            }
        });
    }
    @Override
    public void add() {
        Jdialogg jdialog1 = new Jdialogg();//建立了一个弹窗
        //建立标签

        JLabel jLabel = new JLabel("     新成员的id号：");
        JLabel jLabel1 = new JLabel("    新成员的名字：");
        JLabel jLabel2 = new JLabel("新成员的手机号：");

        //建立的是文本框
        JTextField jTextField = new JTextField();
        JTextField jTextField1 = new JTextField();
        JTextField jTextField2 = new JTextField();

        //进行输入的存储
        //文本框1
        //建立一个保存的按钮
        JButton jButton = new JButton("保存信息");
        jButton.setBounds(220, 360, 100, 40);
        jButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PhonerelationshipEntity p = new PhonerelationshipEntity(jTextField.getText(), jTextField1.getText(), jTextField2.getText());
                pdao.add(p);
                jdialog1.setVisible(false);
            }
        });
        //文本框的位置
        jTextField.setBounds(200, 112, 200, 20);
        jTextField1.setBounds(200, 152, 200, 20);
        jTextField2.setBounds(200, 192, 200, 20);
        //标签的位置
        jLabel.setBounds(100, 20, 200, 200);
        jLabel1.setBounds(100, 60, 200, 200);
        jLabel2.setBounds(100, 100, 200, 200);
        //放入容器内
        Container container1 = jdialog1.getContentPane();
        container1.setLayout(null);
        container1.add(jLabel);
        container1.add(jLabel1);
        container1.add(jLabel2);
        container1.add(jTextField);
        container1.add(jTextField1);
        container1.add(jTextField2);
        container1.add(jButton);
    }
}
