package utils;

import javax.swing.*;
import java.awt.*;


public class Table extends Jdialogg {

    public Table() {


        setVisible(true);
        setResizable(false);
        setBounds(100, 100, 800, 800);
        Container container = new Container();
        container=getContentPane();
        this.setLayout(new BorderLayout());
        JTable table=new JTable();
        JScrollPane sp=new JScrollPane(table);
        container.add(sp,BorderLayout.CENTER);



    }
}