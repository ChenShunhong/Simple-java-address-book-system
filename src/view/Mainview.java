package view;


import service.ViewService;
import service.impl.ViewServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

//主窗口的进入
public class Mainview extends JFrame {
    ViewService v = new ViewServiceImpl();
    public void Mainview() throws ClassNotFoundException, SQLException {
        //数据库的加入
        JFrame jFrame = new JFrame("通讯录系统");//创建对象
        jFrame.setVisible(true);//窗口的可视化
        jFrame.setBounds(650, 150, 700, 400);//窗口的初始化
        jFrame.setResizable(false);
        Container container = jFrame.getContentPane();
        container.setBackground(Color.lightGray);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//关闭事件
        container.setLayout(null);
        //初始化按钮信息
        JLabel jLabelr = new JLabel("通讯录管理系统By陈某宏");
        jLabelr.setFont(new Font("行书", Font.BOLD, 30));
        jLabelr.setForeground(Color.BLUE);
        jLabelr.setBounds(180, 250, 400, 100);
        container.add(jLabelr);
        JButton button1 = new JButton("浏览所有的通讯信息");
        JButton button2 = new JButton("增加通讯录信息");
        JButton button3 = new JButton("查询相应ID或姓名的通讯录成员");
        JButton button4 = new JButton("删除指定的通讯录成员");
        JButton button5 = new JButton("修改指定的通讯录成员");
        jFrame.update(jFrame.getGraphics());
        button1.setBounds(150, 20, 400, 40);
        button2.setBounds(150, 70, 400, 40);
        button3.setBounds(150, 120, 400, 40);
        button4.setBounds(150, 170, 400, 40);
        button5.setBounds(150, 220, 400, 40);
        //添加按钮
        container.add(jLabelr);
        container.add(button1);
        container.add(button2);
        container.add(button3);
        container.add(button4);
        container.add(button5);
        jFrame.update(jFrame.getGraphics());
        button1.addActionListener(new AbstractAction() {//按钮1 增加学生信息
            @Override
            public void actionPerformed(ActionEvent e) {
                v.selectAll();
            }
        });
        //按钮2
        button2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v.add();
            }
        });
        button3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v.selectByxx();

            }
        });
        button4.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v.delete();
            }
        });
        button5.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v.update();
            }
        });
    }
}
















