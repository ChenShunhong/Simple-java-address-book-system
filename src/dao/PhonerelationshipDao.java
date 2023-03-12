package dao;

import entity.PhonerelationshipEntity;

import java.util.List;

public interface PhonerelationshipDao {

    //查找所有通讯录的信息
    public List<PhonerelationshipEntity> selectAll();

    //根据姓名来查找到相应的记录
    public   List<PhonerelationshipEntity> selectByIdorName(String idorname);

    //删除记录
    public int deleteById(String idorallname);

    //更新数据
    public  int updateById(PhonerelationshipEntity p);

    public void add(PhonerelationshipEntity p);
}
