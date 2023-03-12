package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDriverutil {

    public void MysqlDriverutil() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");//加载驱动
    }
    String url="jdbc:mysql://localhost:3306/db02?useUnicode=true&characterEncoding=utf-8&useSSL=true";
    String username="root";
    String password="root";
    public Connection getconnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }
}
