package entity;

import javax.xml.crypto.Data;
import java.util.Date;

public class PhonerelationshipEntity {

    public PhonerelationshipEntity() {
    }

    public PhonerelationshipEntity(String id, String name, String phonenum, Date updatetime) {
        this.id = id;
        this.name = name;
        this.phonenum = phonenum;
        this.updatetime = updatetime;
    }

    public PhonerelationshipEntity(String id, String name, String phonenum) {
        this.id = id;
        this.name = name;
        this.phonenum = phonenum;
    }

    private String id;
    private  String name;
    private  String phonenum;
    private Date creattime;
    private Date updatetime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}
