package dao.impl;

import dao.PhonerelationshipDao;
import entity.PhonerelationshipEntity;
import utils.MysqlDriverutil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PhonerelationshipImpl implements PhonerelationshipDao {

    Connection connection;

    {
        try {
            connection = new MysqlDriverutil().getconnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override

    public List<PhonerelationshipEntity> selectAll() {
        String sql = "select * from phonerelationship";
        PreparedStatement std;
        ArrayList<PhonerelationshipEntity> phonerelationshipEntities = new ArrayList<>();
        try {
            std = connection.prepareStatement(sql);
            ResultSet resultSet = std.executeQuery(sql);
            while (resultSet.next()) {
                PhonerelationshipEntity p = new PhonerelationshipEntity();
                p.setId(resultSet.getString("id"));
                p.setName(resultSet.getString("name"));
                p.setPhonenum(resultSet.getString("phonenum"));
                p.setCreattime(resultSet.getDate("createtime"));
                p.setUpdatetime(resultSet.getDate("updatetime"));
                phonerelationshipEntities.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return phonerelationshipEntities;
    }

    @Override
    public List<PhonerelationshipEntity> selectByIdorName(String idorname) {
        String sql = "select * from phonerelationship where `id`=" + "'" + idorname + "'" + " or `name` like" + " '%" + idorname + "%'";
        PreparedStatement std;
        ArrayList<PhonerelationshipEntity> phonerelationshipEntities = new ArrayList<>();
        try {
            std = connection.prepareStatement(sql);
            ResultSet resultSet = std.executeQuery(sql);
            while (resultSet.next()) {
                PhonerelationshipEntity p = new PhonerelationshipEntity();
                p.setId(resultSet.getString("id"));
                p.setName(resultSet.getString("name"));
                p.setPhonenum(resultSet.getString("phonenum"));
                p.setCreattime(resultSet.getDate("createtime"));
                p.setUpdatetime(resultSet.getDate("updatetime"));
                phonerelationshipEntities.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return phonerelationshipEntities;

    }

    @Override
    public int deleteById(String idorallname) {
        String sql = "delete from phonerelationship where `id`=" + "'" + idorallname + "'" + " or `name`=" + "'" + idorallname + "'";
        PreparedStatement std;
        int i = 0;
        try {
            std = connection.prepareStatement(sql);
            i = std.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return i;

    }

    @Override
    public int updateById(PhonerelationshipEntity p) {
        PreparedStatement std = null;
        Timestamp timestamp = new Timestamp(new Date().getTime());
        int i = 0;
        String sql = "update phonerelationship set `name`=" + "'" + p.getName() + "'" + ",`phonenum`=" + "'" + p.getPhonenum() + "'" + ",updatetime=" + "'" + timestamp + "'" + " where id=" + "'" + p.getId() + "'";
        try {
            std = connection.prepareStatement(sql);
            i = std.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }

    @Override
    public void add(PhonerelationshipEntity p) {
        PreparedStatement std = null;
        String sql = "insert into phonerelationship (`id`,`name`,`phonenum`,`createtime`,`updatetime`) value (?,?,?,?,?)";
        try {
            std = connection.prepareStatement(sql);
            std.setString(1, p.getId());
            std.setString(2, p.getName());
            std.setString(3, p.getPhonenum());
            std.setString(4, String.valueOf(new Timestamp(new Date().getTime())));
            std.setString(5, String.valueOf(new Timestamp(new Date().getTime())));
            std.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
