package com.khbr.induspark.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by Administrator on 2018/9/28 0028.
 */
@Entity
public class RentHouse {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid")
    @Column(length = 32)
    private String id;
    private String houseType;
    private String houseDetail;
    private Date rentDate;
    private Date validDate;
    private String remark;
    private Byte sysStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getHouseDetail() {
        return houseDetail;
    }

    public void setHouseDetail(String houseDetail) {
        this.houseDetail = houseDetail;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Byte getSysStatus() {
        return sysStatus;
    }

    public void setSysStatus(Byte sysStatus) {
        this.sysStatus = sysStatus;
    }

    @Override
    public String toString() {
        return "RentHouse{" +
                "id='" + id + '\'' +
                ", houseType='" + houseType + '\'' +
                ", houseDetail='" + houseDetail + '\'' +
                ", rentDate=" + rentDate +
                ", validDate=" + validDate +
                ", remark='" + remark + '\'' +
                ", sysStatus=" + sysStatus +
                '}';
    }
}
