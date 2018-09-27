package com.khbr.induspark.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Administrator on 2018/9/27 0027.
 */
@Entity
public class HouseDetail {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid")
    @Column(length = 32)
    private String id;
    private String district;
    private String building;
    private String floor;
    private String house;
    private Double area;
    private String remark;
    @ManyToOne
    @JoinColumn(name = "house_type_id")
    private HouseType houseType;
    private Byte sysStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public HouseType getHouseType() {
        return houseType;
    }

    public void setHouseType(HouseType houseType) {
        this.houseType = houseType;
    }

    public Byte getSysStatus() {
        return sysStatus;
    }

    public void setSysStatus(Byte sysStatus) {
        this.sysStatus = sysStatus;
    }

    @Override
    public String toString() {
        return "HouseDetail{" +
                "id='" + id + '\'' +
                ", district='" + district + '\'' +
                ", building='" + building + '\'' +
                ", floor='" + floor + '\'' +
                ", house='" + house + '\'' +
                ", area=" + area +
                ", remark='" + remark + '\'' +
                ", houseType=" + houseType +
                ", sysStatus=" + sysStatus +
                '}';
    }
}
